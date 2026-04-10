package com.notify.pigeon.sender.dtos;

import lombok.Data;

@Data
public class SenderResponseDTO {
    private Long id;
    private String organization_name;
    private String contact;
    private String email;
}
