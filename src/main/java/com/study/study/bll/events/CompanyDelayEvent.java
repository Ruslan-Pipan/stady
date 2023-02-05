package com.study.study.bll.events;

import com.study.study.mdl.CompanyEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CompanyDelayEvent extends CompanyEvent {
    @Override
    protected void start(CompanyEntity companyEntity) {

    }

    @Override
    protected Optional<String> validation(CompanyEntity companyEntity) {
        StringBuilder errorBuilder = new StringBuilder();

        if (Objects.isNull(companyEntity.delay())){
            errorBuilder.append("The delay event must have 'delay' field ");
        }
        if (Objects.equals(companyEntity.status(), "DRAFT")){
            errorBuilder.append("AND ");
            errorBuilder.append("status shouldn't be draft.");
        }

        return errorBuilder.isEmpty() ? Optional.empty() : Optional.of(errorBuilder.toString());

    }
}
