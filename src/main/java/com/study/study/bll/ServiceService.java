package com.study.study.bll;

import com.study.study.dao.AbstractCrudRepository;
import com.study.study.mdl.ServiceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceService extends AbstractCrudService<ServiceEntity>{
    private final AbstractCrudRepository<ServiceEntity> crudRepository;

    @Override
    public AbstractCrudRepository<ServiceEntity> abstractCrudRepository() {
        return crudRepository;
    }
}
