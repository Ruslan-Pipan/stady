package com.study.study.mdl;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@Setter
public class ServiceEntity {
    private Integer id;
    private String serviceName;
}
