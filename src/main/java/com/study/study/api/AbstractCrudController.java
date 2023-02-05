package com.study.study.api;

import com.study.study.bll.AbstractCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractCrudController<E> {
    public abstract AbstractCrudService<E> crudService();

    public ResponseEntity<E> create(E obj) {
        return ResponseEntity.ok(crudService().create(obj));
    }

    public ResponseEntity<E> update(E obj) {
        return ResponseEntity.ok(crudService().update(obj));
    }

    public ResponseEntity<E> get(E e) {
        return ResponseEntity.ok(crudService().get(e));
    }

    public ResponseEntity<HttpStatus> deactivate(E e) {
        crudService().deactivate(e);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
