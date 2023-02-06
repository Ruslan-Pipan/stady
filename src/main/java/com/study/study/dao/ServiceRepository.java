package com.study.study.dao;

import com.study.study.mdl.ServiceEntity;
import com.study.study.mdl.table.QService;
import com.study.study.query.QueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceRepository extends AbstractCrudRepository<ServiceEntity>{
    @Autowired
    public ServiceRepository(QueryFactory queryFactory) {
        super(new QService(), queryFactory);
    }
}
