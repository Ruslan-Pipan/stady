package com.study.study.mdl;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Optional;

@Accessors(fluent = true)
@Getter
@Setter
public class CompanyEntity {
    private Integer id;
    private String name;
    private Boolean scheduled;
    private Integer delay;
    private String period;
    private String status;

    private Optional<EventType> eventType = Optional.empty();
}
