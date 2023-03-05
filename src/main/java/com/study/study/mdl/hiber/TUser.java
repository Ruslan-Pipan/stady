package com.study.study.mdl.hiber;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "T_User")
@Accessors(fluent = true)
@Setter
@EqualsAndHashCode
public class TUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @ManyToOne
    @JoinColumn(name = "companyId", foreignKey = @ForeignKey(name = "FK_T_User_companyId_T_Company"))
    private TCompany company;

    @JsonIgnore
    public TCompany getCompany() {
        return company;
    }

    public void setCompany(TCompany company) {
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    @Setter(AccessLevel.NONE)
    private Integer companyId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer getCompanyId() {
        return company.getId();
    }
}
