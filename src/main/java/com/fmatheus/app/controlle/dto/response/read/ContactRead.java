package com.fmatheus.app.controlle.dto.response.read;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRead {
    private String email;
    private String phone;
}

