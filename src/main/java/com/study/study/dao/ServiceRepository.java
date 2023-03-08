package com.study.study.dao;

import com.study.study.mdl.hiber.TCompany;
import com.study.study.mdl.hiber.TService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
@Transactional
public class ServiceRepository extends CrudRepository<TService> {
    public ServiceRepository(EntityManager entityManager, PersistObjectWithReferences<TService> persistObjectWithReferences) {
        super(entityManager, persistObjectWithReferences);
    }

    @Override
    public Optional<TService> getByPrimaryKey(TService eDto) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<TService> query = criteria.createQuery(TService.class);
        Root<TService> serviceAlias = query.from(TService.class);
        Join<TService, TCompany> companyAlias = serviceAlias.join("company");

        List<Predicate> predicates = List.of(
                criteria.equal(companyAlias.get("id"), eDto.getCompany().getId()),
                criteria.equal(serviceAlias.get("id"), eDto.getId()));

        query.select(serviceAlias)
                .where(predicates.toArray(Predicate[]::new));

        return Optional.ofNullable(entityManager.createQuery(query).getSingleResult());
    }
}
