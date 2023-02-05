package com.study.study.bll;

import com.study.study.dao.AbstractCrudRepository;
import com.study.study.mdl.CompanyEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService extends AbstractCrudService<CompanyEntity> {
    private final AbstractCrudRepository<CompanyEntity> crudRepository;


    @Override
    public AbstractCrudRepository<CompanyEntity> abstractCrudRepository() {
        return crudRepository;
    }

    @Override
    public CompanyEntity create(CompanyEntity companyEntity) {
        CompanyEntity createdCompany = crudRepository.create(companyEntity);

        companyEntity.eventType().ifPresent(type -> type.event.process(companyEntity));

        log.info("Company Service create.");
        return createdCompany;
    }

}
