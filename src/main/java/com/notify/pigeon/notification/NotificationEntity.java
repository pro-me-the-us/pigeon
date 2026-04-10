package com.notify.pigeon.notification;

import com.notify.pigeon.common.NotificationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "notifications")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @NonNull
    private Long userid;

    @NonNull
    private Long senderid;

    @NonNull
    @Enumerated
    private NotificationStatus status;

    @NonNull
    private String Message;

    @NonNull
    private Date createAt;

    @NonNull
    private Date scheduledAt;
}



