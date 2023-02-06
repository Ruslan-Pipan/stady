package com.study.study.bll;

import com.study.study.dao.AbstractCrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class AbstractCrudService<E> {
    public abstract AbstractCrudRepository<E> abstractCrudRepository();

    public E create(E e) {
        return abstractCrudRepository().create(e);
    }

    public E update(E e) {
        return abstractCrudRepository().update(e);
    }

    public Optional<E> get(E e) {
        return abstractCrudRepository().get(e);
    }

    public void deactivate(E e) {
        abstractCrudRepository().deactivate(e);
    }
}
