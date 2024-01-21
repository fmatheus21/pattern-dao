package com.fmatheus.app.model.dao;

import com.fmatheus.app.model.entity.Person;
import com.fmatheus.app.model.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class FactoryDao {

    @PersistenceContext
    private EntityManager manager;


    protected InterfaceGenericDao<User> userFactoryDao() {
        return new GenericDao<>(this.manager, User.class);
    }

    protected InterfaceGenericDao<Person> personFactoryDao() {
        return new GenericDao<>(this.manager, Person.class);
    }

}
