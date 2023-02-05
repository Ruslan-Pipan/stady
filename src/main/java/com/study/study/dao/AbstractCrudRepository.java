package com.study.study.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public abstract class AbstractCrudRepository<E> {
    public E create(E e){
        log.info("Create: {}", e.getClass());
        return null;
    }

    public E update(E e){
        log.info("Update: {}", e.getClass());
        return null;
    }

    public E get(E e){
        log.info("Get: {}", e.getClass());
        return null;
    }

    public void deactivate(E e){
        log.info("Deactivate: {}", e.getClass());
    }
}
