package com.study.study.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface CrudController<E> {
    ResponseEntity<E> create(E obj);
    ResponseEntity<E> update(Integer id, E e);
    ResponseEntity<E> get(Integer id);
    ResponseEntity<HttpStatus> deactivate(Integer id);
}
