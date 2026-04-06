package com.notify.pigeon.sender;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sender")
public class SenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NonNull
    private Long id;

    @NonNull
    private String organization_name;

    @NonNull
    private String password;

    @NonNull
    private String contact;

    @NonNull
    private String email;

}
