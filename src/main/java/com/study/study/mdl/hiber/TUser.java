package com.study.study.mdl.hiber;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "T_User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
public class TUser {
    @Id
    private Integer id;

    private String email;

    @JsonIgnore
    private String password;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "companyId", foreignKey = @ForeignKey(name = "FK_T_User_companyId_T_Company"))
    private TCompany company;

    @JsonIgnore
    @MapsId
    @OneToOne
    private TPerson person;

    @ManyToMany(mappedBy = "users")
    private List<TRole> roles;

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private List<TService> services;

    @Transient
    @Setter(AccessLevel.NONE)
    private Integer companyId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer getCompanyId() {
        return company.getId();
    }
}
