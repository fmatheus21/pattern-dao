package com.fmatheus.app.controlle.converter;

public interface MapperConverter<T, S, U> {
    T converterToEntity(S s);

    U converterToResponse(T t);
}