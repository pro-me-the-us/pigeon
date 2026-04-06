package com.notify.pigeon.user.dtos;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private String contact;
    private String email;
}
