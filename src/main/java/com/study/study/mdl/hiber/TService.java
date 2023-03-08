package com.study.study.mdl.hiber;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "T_Service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String serviceName;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private TCompany company;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "T_ServiceUser",
            joinColumns = @JoinColumn(name = "serviceId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<TUser> users;
}
