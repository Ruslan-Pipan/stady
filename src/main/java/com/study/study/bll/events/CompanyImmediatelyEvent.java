package com.study.study.bll.events;

import com.study.study.bll.events.CompanyEvent;
import com.study.study.mdl.CompanyEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyImmediatelyEvent extends CompanyEvent {
    @Override
    protected void start(CompanyEntity companyEntity) {

    }

    @Override
    protected Optional<String> validation(CompanyEntity companyEntity) {
        return Optional.empty();
    }
}
