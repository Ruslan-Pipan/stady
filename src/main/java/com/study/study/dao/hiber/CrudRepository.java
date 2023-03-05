package com.study.study.dao.hiber;

import com.study.study.util.ReflectionHelper;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class CrudRepository<E> implements ICrudRepository<E> {

    protected final EntityManager entityManager;

    @Override
    public E add(E eDto) {
        entityManager.persist(eDto);
        return eDto;
    }

    @Override
    public E update(E eDto) {
        return entityManager.merge(eDto);
    }

    @Override
    public Optional<E> getByPrimaryKey(E eDto) {
        Method getIdMethod = ReflectionHelper.getMethod(eDto.getClass(), ReflectionHelper.getIdField(eDto.getClass()));

        Object primaryKey;
        try {
            primaryKey = getIdMethod.invoke(eDto);
        } catch (IllegalAccessException | InvocationTargetException e) {
           throw new RuntimeException("The entity have to have get method for primary filed.");
        }

        return Optional.ofNullable((E) entityManager.find(eDto.getClass(), primaryKey));
    }

    @Override
    public void delete(E eDto) {
        E e = getByPrimaryKey(eDto)
                .orElseThrow(() -> new RuntimeException("Rejection to delete."));
        entityManager.remove(e);
    }
}
