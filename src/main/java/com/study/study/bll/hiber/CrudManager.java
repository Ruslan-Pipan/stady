package com.study.study.bll.hiber;

import com.study.study.dao.hiber.ICrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrudManager<E> implements ICrudManager<E>{
    private final ICrudRepository<E> crudRepository;

    @Override
    public E add(E eDto) {
        return crudRepository.save(eDto);
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
