package com.notify.pigeon.sender.dtos;

import lombok.Data;

@Data
public class CreateSenderDTO {
    private String organization_name;
    private String password;
    private String contact;
    private String email;
}
