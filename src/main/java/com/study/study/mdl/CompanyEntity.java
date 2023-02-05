package com.study.study.mdl;

import lombok.Builder;

import java.util.Optional;

@Builder(toBuilder = true)
public class CompanyEntity {
    public final String name;
    public final boolean scheduled;
    public final Integer delay;
    public final String period;
    public final String status;

    public final Optional<EventType> eventType;
}
