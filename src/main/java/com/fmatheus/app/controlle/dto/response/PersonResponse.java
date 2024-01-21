package com.fmatheus.app.controlle.dto.response;

import com.fmatheus.app.controlle.dto.response.read.ContactRead;
import com.fmatheus.app.controlle.dto.response.read.PersonTypeRead;
import com.fmatheus.app.controlle.dto.response.read.UserRead;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponse {
    private String name;
    private String document;
    private LocalDateTime createdAt;
    private PersonTypeRead personType;
    private ContactRead contact;
    private UserRead user;
}
