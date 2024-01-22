package com.fmatheus.app.controlle.resource;


import com.fmatheus.app.controlle.dto.response.PersonResponse;
import com.fmatheus.app.controlle.rule.UserRule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserRule rule;

    @GetMapping
    public ResponseEntity<Collection<PersonResponse>> findAll() {
        var response = this.rule.findAll();
        return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/named-query")
    public ResponseEntity<Collection<PersonResponse>> findAllNamedQuery() {
        var response = this.rule.findAllNamedQuery();
        return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/named-query/parameter")
    public PersonResponse findByStringNamedQuery(@RequestParam String username) {
        return this.rule.findByStringNamedQuery(username);
    }

}
