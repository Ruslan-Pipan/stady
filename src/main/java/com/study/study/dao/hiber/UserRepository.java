package com.study.study.dao.hiber;

import com.study.study.mdl.hiber.TCompany;
import com.study.study.mdl.hiber.TUser;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Primary
@Repository
@Transactional
public class UserRepository extends CrudRepository<TUser> {
    public UserRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public TUser add(TUser eDto) {
        var company = entityManager.getReference(TCompany.class, eDto.getCompany().getId());
        eDto.setCompany(company);
        entityManager.persist(eDto);
        return eDto;
    }
}
