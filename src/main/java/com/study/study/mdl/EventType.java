package com.study.study.mdl;

import com.study.study.bll.events.CompanyDelayEvent;
import com.study.study.bll.events.CompanyEvent;
import com.study.study.bll.events.CompanyScheduledEvent;
import com.study.study.bll.events.CompanyImmediatelyEvent;

public enum EventType {
    SCHEDULED(new CompanyScheduledEvent()),
    DELAY(new CompanyDelayEvent()),
    IMMEDIATELY(new CompanyImmediatelyEvent());

    public CompanyEvent event;

    EventType(CompanyEvent event) {
        this.event = event;
    }
}
