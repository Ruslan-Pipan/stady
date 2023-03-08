package com.study.study.bll;

import com.study.study.dao.ICrudRepository;
import com.study.study.mdl.hiber.TService;
import org.springframework.stereotype.Service;

@Service
public class ServiceManager extends CrudManager<TService> {
    public ServiceManager(ICrudRepository<TService> crudRepository) {
        super(crudRepository);
    }

    @Override
    public TService get(TService eDto) {
        return super.get(eDto);
    }
}
