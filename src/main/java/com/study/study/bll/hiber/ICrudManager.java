package com.study.study.bll.hiber;

public interface ICrudManager<E> {
    E add(E eDto);
    E update(E eDto);
    E get(E eDto);
    void delete(E eDto);
}
