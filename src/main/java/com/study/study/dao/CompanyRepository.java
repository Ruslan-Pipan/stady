package com.study.study.dao;

import com.study.study.mdl.CompanyEntity;
import com.study.study.mdl.table.QCompany;
import com.study.study.mdl.table.QService;
import com.study.study.query.QTable;
import com.study.study.query.QueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
public class CompanyRepository extends AbstractCrudRepository<CompanyEntity>{
    private final static QCompany qCompany = new QCompany();
    private final static QService qService = new QService();

    @Autowired
    public CompanyRepository(QueryFactory queryFactory) {
        super(new QCompany(), queryFactory);
    }

    @Override
    public Optional<CompanyEntity> get(CompanyEntity companyEntity) {
        String allSelect = queryFactory.select(qCompany)
                .where(QCompany.id.eq(companyEntity.id()))
                .fetch();

        log.info(allSelect);

        String selectByFiled = queryFactory.select(QCompany.id, QCompany.delay, QCompany.period, QService.serviceName)
                .from(qCompany)
                .innerJoin(qService)
                .on(QCompany.id, QService.companyId)
                .where(QCompany.id.eq(companyEntity.id()))
                .fetch();

        log.info(selectByFiled);
        return super.get(companyEntity);
    }
}
