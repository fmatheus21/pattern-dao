package com.fmatheus.app.controlle.converter;


import com.fmatheus.app.controlle.dto.response.PersonResponse;
import com.fmatheus.app.model.entity.Person;

public interface PersonConverter extends MapperConverter<Person, Object, PersonResponse> {
}
