package com.study.study.dao;

import com.study.study.query.QTable;
import com.study.study.query.QueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
public abstract class AbstractCrudRepository<E> {
    private final QTable<E> qTable;
    public final QueryFactory queryFactory;

    protected AbstractCrudRepository(QTable<E> qTable, QueryFactory queryFactory) {
        this.qTable = qTable;
        this.queryFactory = queryFactory;
    }

    public E create(E e){
        log.info("Create: {}", e.getClass());
        return null;
    }

    public E update(E e){
        log.info("Update: {}", e.getClass());
        return null;
    }

    public Optional<E> get(E e){
        return Optional.empty();
    }

    public void deactivate(E e){
        log.info("Deactivate: {}", e.getClass());
    }
}
