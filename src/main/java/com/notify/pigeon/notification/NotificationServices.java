package com.notify.pigeon.notification;

import com.notify.pigeon.notification.dtos.CreateNotificationDTO;
import org.springframework.stereotype.Service;

@Service
public class NotificationServices {
    private final NotificationRepository notificationRepository;

    public NotificationServices(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

//    NotificationEntity CreateNotification(CreateNotificationDTO request){
//
//    }
}
