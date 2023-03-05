package com.study.study.bll.hiber;

import com.study.study.dao.hiber.ICrudRepository;
import com.study.study.util.ReflectionHelper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Service
@RequiredArgsConstructor
public class CrudManager<E> implements ICrudManager<E>{
    private final ICrudRepository<E> crudRepository;

    @Override
    public E add(E eDto) {
        return crudRepository.add(eDto);
    }

    @SneakyThrows
    @Override
    public E add(E eDto, Class<?> referenceClass) {
        return crudRepository.add(eDto, referenceClass);
    }

    @Override
    public E update(E eDto) {
        return crudRepository.update(eDto);
    }

    @Override
    public E get(E eDto) {
        return crudRepository.getByPrimaryKey(eDto)
                .orElseThrow(()-> new RuntimeException("The entity hasn't been fount."));
    }

    @Override
    public void delete(E eDto) {
        crudRepository.delete(eDto);
    }
}
