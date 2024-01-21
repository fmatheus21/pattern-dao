package com.fmatheus.app.controlle.dto.response.read;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRead {
    private String username;
    private boolean active;
}
