package com.fmatheus.app.model.dao;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class GenericDao<T> implements InterfaceGenericDao<T> {

    private final EntityManager manager;
    private final Class<T> clazz;

    public GenericDao(EntityManager manager, Class<T> clazz) {
        this.manager = manager;
        this.clazz = clazz;
    }

    @Override
    public T save(T t) {
        return manager.merge(t);
    }

    @Override
    public T update(T t) {
        return manager.merge(t);
    }

    @Override
    public void deleteByInteger(String attribute, int criteria) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaDelete<T> delete = builder.createCriteriaDelete(clazz);
        Root<T> root = delete.from(clazz);
        delete.where(builder.equal(root.<Integer>get(attribute), criteria));
        Query query = manager.createQuery(delete);
        query.executeUpdate();
    }

    @Override
    public void deleteByObject(String attribute, Object criteria) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaDelete<T> delete = builder.createCriteriaDelete(clazz);
        Root<T> root = delete.from(clazz);
        delete.where(builder.equal(root.<Object>get(attribute), criteria));
        Query query = manager.createQuery(delete);
        query.executeUpdate();
    }

    @Override
    public T findByString(String attribute, String criteria) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.where(builder.equal(root.<String>get(attribute), criteria));
        TypedQuery<T> tq = manager.createQuery(cq);
        try {
            return tq.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            return null;
        }
    }

    @Override
    public T findByInteger(String attribute, int criteria) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.where(builder.equal(root.<Integer>get(attribute), criteria));
        TypedQuery<T> tq = manager.createQuery(cq);
        try {
            return tq.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            return null;
        }
    }

    @Override
    public T findByObject(String attribute, Object criteria) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.where(builder.equal(root.<T>get(attribute), criteria));
        TypedQuery<T> tq = manager.createQuery(cq);
        try {
            return tq.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            return null;
        }
    }

    @Override
    public Collection<T> findAllOrderByAsc(String attributeOrderby) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.orderBy(builder.asc(root.<String>get(attributeOrderby)));
        TypedQuery<T> tq = manager.createQuery(cq);
        try {
            return tq.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<T> findAllOrderByDesc(String attributeOrderby) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.orderBy(builder.desc(root.<String>get(attributeOrderby)));
        TypedQuery<T> tq = manager.createQuery(cq);
        try {
            return tq.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<T> findAllByString(String attribute, String criteria) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.where(builder.equal(root.<String>get(attribute), criteria));
        TypedQuery<T> tq = manager.createQuery(cq);
        try {
            return tq.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<T> findAllByInteger(String attribute, int criteria) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.where(builder.equal(root.<Integer>get(attribute), criteria));
        TypedQuery<T> tq = manager.createQuery(cq);
        try {
            return tq.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<T> findAllByStringOrderByAsc(String attributeOrderBy, String attribute, String criteria) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.where(builder.equal(root.<String>get(attribute), criteria));
        cq.orderBy(builder.desc(root.<String>get(attributeOrderBy)));
        TypedQuery<T> tq = manager.createQuery(cq);
        try {
            return tq.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<T> findAllByIntegerOrderByDesc(String attributeOrderby, String attribute, int criteria) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.where(builder.equal(root.<Integer>get(attribute), criteria));
        cq.orderBy(builder.desc(root.<String>get(attributeOrderby)));
        TypedQuery<T> tq = manager.createQuery(cq);
        try {
            return tq.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<T> findAllByObject(String attribute, Object criteria) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.where(builder.equal(root.<Object>get(attribute), criteria));
        TypedQuery<T> tq = manager.createQuery(cq);
        try {
            return tq.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<T> findAllByBooleanOrderByAsc(String attribute, boolean criteria, String attributeOrderby) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.where(builder.equal(root.<Boolean>get(attribute), criteria));
        cq.orderBy(builder.asc(root.<String>get(attributeOrderby)));
        TypedQuery<T> tq = manager.createQuery(cq);
        try {
            return tq.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<T> findAllByLike(String attribute, String criteria) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        List<Predicate> predicates = new ArrayList<>();
        Predicate condition = builder.like(root.<String>get(attribute), "%" + criteria + "%");
        predicates.add(condition);
        cq.where(builder.and(predicates.toArray(new Predicate[]{})));
        TypedQuery<T> tq = manager.createQuery(cq);
        try {
            return tq.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<T> findAllBetweenDate(String attribute, Date criteriaStart, Date criteriaEnd) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.where(builder.between(root.<Date>get(attribute), criteriaStart, criteriaEnd));
        TypedQuery<T> tq = manager.createQuery(query);
        try {
            return tq.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<T> findAllByDate(String attribute, Date criteria) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.where(builder.equal(root.<Date>get(attribute), criteria));
        TypedQuery<T> tq = manager.createQuery(cq);
        try {
            return tq.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<T> findFirstResult() {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(clazz);
        TypedQuery<T> tq = manager.createQuery(cq);
        tq.setFirstResult(0);
        try {
            return tq.getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<T> findAllNamedQuery(String query) {
        TypedQuery<T> typedQuery = this.manager.createNamedQuery(query, clazz);
        return typedQuery.getResultList();
    }

    @Override
    public T findByStringNamedQuery(String query, String attribute, String parameter) {
        TypedQuery<T> typedQuery = this.manager.createNamedQuery(query, clazz)
                .setParameter(attribute, parameter);
        return typedQuery.getSingleResult();
    }

}
