package com.study.study.bll;

import com.study.study.dao.CompanyRepository;
import com.study.study.mdl.CompanyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void createCompany(CompanyEntity companyEntity) {
        companyRepository.insertCompany(companyEntity);

        companyEntity.eventType.ifPresent(type -> type.event.process(companyEntity));
    }
}
