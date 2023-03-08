package com.study.study.mdl.hiber;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "T_Person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @JsonIgnore
    @OneToOne(mappedBy = "person")
    private TUser user;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<TAddress> addresses;
}
