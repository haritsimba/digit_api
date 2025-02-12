package com.hackathon.digitalisation;

import com.hackathon.digitalisation.dtos.NotificationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final SimpMessagingTemplate messagingTemplate;

    // Notification pour un groupe (messages)
    public void sendMessageNotification(Long groupId, NotificationDTO notification) {
        messagingTemplate.convertAndSend("/topic/group/" + groupId, notification);
    }

    // Notification pour une classe (emploi du temps)
    public void sendScheduleNotification(String school, String department, String level, NotificationDTO notification) {
        String topic = "/topic/class/" + school + "/" + department + "/" + level;
        messagingTemplate.convertAndSend(topic, notification);
    }
}
