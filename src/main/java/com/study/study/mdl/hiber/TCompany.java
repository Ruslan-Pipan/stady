package com.study.study.mdl.hiber;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "T_Company")
@Accessors(fluent = true)
@Setter
public class TCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
