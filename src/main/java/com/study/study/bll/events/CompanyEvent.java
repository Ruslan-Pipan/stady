package com.study.study.bll.events;

import com.study.study.mdl.CompanyEntity;

import java.util.Optional;

public abstract class CompanyEvent {
    public void process(CompanyEntity companyEntity){
        Optional<String> error = validation(companyEntity);
        if (error.isPresent()) {
            throw new RuntimeException(error.get());
        }
        start(companyEntity);
    }

    protected abstract void start(CompanyEntity companyEntity);
    protected abstract Optional<String> validation(CompanyEntity companyEntity);
}
