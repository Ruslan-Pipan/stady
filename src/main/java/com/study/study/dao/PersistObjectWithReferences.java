package com.study.study.dao;

import com.study.study.util.ReflectionHelper;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Service
public class PersistObjectWithReferences<E> {

    public void persist(EntityManager entityManager, E eDto, Class<?>... referenceTypes) {
        prepareToPersistWithForeignKeys(entityManager, eDto, referenceTypes);
        entityManager.persist(eDto);
    }

    private void prepareToPersistWithForeignKeys(EntityManager entityManager, E eDto, Class<?>... referenceTypes){
        for (Class<?> currentRefClasses : referenceTypes) {
            setProxyToDto(entityManager, eDto, currentRefClasses, ReflectionHelper.formatTableClassName(currentRefClasses));
        }
    }

    private void setProxyToDto(EntityManager entityManager, E eDto, Class<?> currentRefClasses, String refClassNameWithoutT) {
        try {
            Object refObjectId = getIdFromRefObject(eDto, currentRefClasses, refClassNameWithoutT);
            Object referenceProxyObject = entityManager.getReference(currentRefClasses, refObjectId);
            ReflectionHelper.setMethod(eDto.getClass(), refClassNameWithoutT, currentRefClasses)
                    .invoke(eDto, referenceProxyObject);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Object getIdFromRefObject(E eDto, Class<?> currentRefClasses, String refClassNameWithoutT)
            throws InvocationTargetException, IllegalAccessException {
        Object refObject = ReflectionHelper.getMethod(eDto.getClass(), refClassNameWithoutT).invoke(eDto);
        Field idFieldRefClasses = ReflectionHelper.getIdField(currentRefClasses);
        Method getIdRefClasses = ReflectionHelper.getMethod(currentRefClasses, idFieldRefClasses);
        return getIdRefClasses.invoke(refObject);
    }
}
