package com.fmatheus.app.controlle.constant;

public class NamedQueryConstant {

    private NamedQueryConstant() {
        throw new IllegalStateException(this.getClass().getName());
    }

    public static final String USER_FIND_ALL = "User.findAll";
    public static final String USER_BY_USERNAME = "User.findByUsername";
}
