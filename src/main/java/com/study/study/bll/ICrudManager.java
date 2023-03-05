package com.study.study.bll;

public interface ICrudManager<E> {
    E add(E eDto);
    E add(E eDto, Class<?> referenceClass);
    E update(E eDto);
    E get(E eDto);
    void delete(E eDto);
}
