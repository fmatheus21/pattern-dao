package com.fmatheus.app.controlle.rule;


import com.fmatheus.app.controlle.converter.PersonConverter;
import com.fmatheus.app.controlle.dto.response.PersonResponse;
import com.fmatheus.app.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class UserRule {

    private final UserService userService;

    private final PersonConverter personConverter;

    public Collection<PersonResponse> findAll() {
        var result = this.userService.findAllOrderByAsc("username");
        return result.stream().map(map -> this.personConverter.converterToResponse(map.getPerson())).toList();
    }

    public Collection<PersonResponse> findAllNamedQuery() {
        var result = this.userService.findAllNamedQuery();
        return result.stream().map(map -> this.personConverter.converterToResponse(map.getPerson())).toList();
    }

    public PersonResponse findByStringNamedQuery(String username) {
        var result = this.userService.findByStringNamedQuery(username);
        return this.personConverter.converterToResponse(result.getPerson());
    }
}


