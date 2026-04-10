package com.notify.pigeon.sender;


import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "senders")
public class SenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
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
