package com.notify.pigeon.notification.dtos;

import com.notify.pigeon.common.NotificationStatus;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class CreateNotificationDTO {
    private Long userid;
    private Long senderid;
    private NotificationStatus status;
    private String Message;
    private Date createAt;
    private Date scheduledAt;
}
