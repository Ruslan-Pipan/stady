package com.study.study.dao.hiber;

import java.util.Optional;

public interface ICrudRepository<E> {
    E save(E eDto);
    E update(E eDto);
    Optional<E> getByPrimaryKey(E eDto);
    void delete(E eDto);
}
