package com.study.study.dao.hiber;

import java.util.Optional;

public interface ICrudRepository<E> {
    E add(E eDto);
    E add(E eDto, Class<?>... referenceClass);
    E update(E eDto);
    Optional<E> getByPrimaryKey(E eDto);
    void delete(E eDto);
}
