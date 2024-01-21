package com.fmatheus.app.model.dao;


import java.util.Collection;
import java.util.Date;


public interface InterfaceGenericDao<T> {

    T save(T t);

    T update(T t);

    void deleteByInteger(String attribute, int criteria);

    void deleteByObject(String attribute, Object criteria);

    T findByString(String attribute, String criteria);

    T findByInteger(String attribute, int criteria);

    T findByObject(String attribute, Object criteria);

    Collection<T> findAllOrderByAsc(String attributeOrderby);

    Collection<T> findAllOrderByDesc(String attributeOrderby);

    Collection<T> findAllByString(String attribute, String criteria);

    Collection<T> findAllByStringOrderByAsc(String attributeOrderBy, String attribute, String criteria);

    Collection<T> findAllByInteger(String attribute, int criteria);

    Collection<T> findAllByIntegerOrderByDesc(String attributeOrderby, String attribute, int criteria);

    Collection<T> findAllByObject(String attribute, Object criteria);

    Collection<T> findAllByBooleanOrderByAsc(String attribute, boolean criteria, String attributeOrderby);

    Collection<T> findAllByLike(String attribute, String criteria);

    Collection<T> findAllBetweenDate(String attribute, Date criteriaStart, Date criteriaEnd);

    Collection<T> findAllByDate(String attribute, Date criteria);

    Collection<T> findFirstResult();

    Collection<T> findAllNamedQuery(String query);

    T findByStringNamedQuery(String query, String attribute, String parameter);
}
