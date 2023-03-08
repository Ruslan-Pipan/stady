package com.study.study.api;

import com.study.study.bll.ICrudManager;
import com.study.study.util.ReflectionHelper;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Log4j2
public class CrudController<E, K> {
    private final ICrudManager<E> crudManager;
    private final Class<E> eClass;
    private final Field idField;

    private final E eInstance;

    public CrudController(ICrudManager<E> crudManager, Class<E> eClass) {
        this.crudManager = crudManager;
        this.eClass = eClass;
        this.idField = ReflectionHelper.getIdField(eClass);

        try {
            this.eInstance = (E) ReflectionHelper.getNoArgumentConstrictor(eClass).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("The entity have to have no arg constructor.", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> get(@PathVariable K id){
        log.info("Start controller.");
        setPrimary(ReflectionHelper.setMethod(eClass, idField), id);
        E e = crudManager.get(eInstance);
        log.info("Finished controller.");
        return ResponseEntity.ok(e);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> delete(@PathVariable K id){
        setPrimary(ReflectionHelper.setMethod(eClass, idField), id);
        crudManager.delete(eInstance);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private void setPrimary(Method setMethod, K id){
        try {
            setMethod.invoke(eInstance, id);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("The entity have to have a set method for primary filed." ,e);
        }

    }

//    @PostMapping
//    public ResponseEntity<E> add(@RequestBody E companyDto){
//        return ResponseEntity.ok(crudManager.add(companyDto));
//    }
}
