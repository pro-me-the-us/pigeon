package com.notify.pigeon.user.dtos;

import lombok.Data;

@Data
public class CreateUserDTO {
    private String username;
    private String password;
    private String contact;
    private String email;
}
