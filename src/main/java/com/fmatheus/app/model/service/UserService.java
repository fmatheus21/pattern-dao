package com.fmatheus.app.model.service;

import com.fmatheus.app.controlle.constant.NamedQueryConstant;
import com.fmatheus.app.model.dao.FactoryDao;
import com.fmatheus.app.model.entity.User;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;

@Service
public class UserService extends FactoryDao implements Serializable {

    public User save(User user) {
        return userFactoryDao().save(user);
    }

    public Collection<User> findAllOrderByAsc(String attributeOrderby) {
        return userFactoryDao().findAllOrderByAsc(attributeOrderby);
    }

    public Collection<User> findAllNamedQuery() {
        return userFactoryDao().findAllNamedQuery(NamedQueryConstant.USER_FIND_ALL);
    }

    public User findByStringNamedQuery(String parameter) {
        return userFactoryDao().findByStringNamedQuery(NamedQueryConstant.USER_BY_USERNAME, "username", parameter);
    }

}
