package com.hackathon.digitalisation.services;

import com.hackathon.digitalisation.NotificationService;
import com.hackathon.digitalisation.dtos.GetMessagesIn;
import com.hackathon.digitalisation.dtos.NotificationDTO;
import com.hackathon.digitalisation.dtos.SendMessageIn;
import com.hackathon.digitalisation.entitites.Message;
import com.hackathon.digitalisation.repositories.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class MessageServices {

    MessageRepository messageRepository;
    NotificationService notificationService;

    public ResponseEntity<Message> createMessage(SendMessageIn messageInfo){
        Message message = new Message();

        message.setContent(messageInfo.content());
        message.setFromId(messageInfo.from());
        message.setFromType(messageInfo.fromType());
        message.setRecipientId(messageInfo.to());
        message.setRecipientType(messageInfo.recipientType());
        message.setType(messageInfo.type());
        message.setLink(messageInfo.attachmentLink());


        Message savedMessage = messageRepository.save(message);
        notificationService.sendMessageNotification(message.getRecipientId(), new NotificationDTO("message",savedMessage));
        return ResponseEntity.ok().body(savedMessage);
    }

    public ResponseEntity<List<Message>> getMessages(GetMessagesIn messagesFilter){
        Date dateBefore = new Date();
        if (messagesFilter.before() != null && messagesFilter.before() != 0) {
            dateBefore = new Date(messagesFilter.before());
            System.out.println(dateBefore);
        }
        System.out.println(messagesFilter.chatId()+" "+messagesFilter.chatType()+" " + messagesFilter.before());
        List<Message> messages = messageRepository.findTop50MessagesBefore(dateBefore,messagesFilter.chatId(),messagesFilter.chatType());
        return ResponseEntity.ok().body(messages);
    }
}