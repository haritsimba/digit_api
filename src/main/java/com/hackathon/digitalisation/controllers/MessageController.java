package com.hackathon.digitalisation.controllers;

import com.hackathon.digitalisation.dtos.GetMessagesIn;
import com.hackathon.digitalisation.dtos.SendMessageIn;
import com.hackathon.digitalisation.entitites.Message;
import com.hackathon.digitalisation.services.MessageServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("message")
public class MessageController {

    MessageServices messageServices;

    @PostMapping(path = "send")
    public ResponseEntity<Message> sendMessage(@RequestBody SendMessageIn message){
        return messageServices.createMessage(message);
    }

    @PostMapping("get")
    public ResponseEntity<List<Message>> getTop50MessageByGroup( @RequestBody GetMessagesIn getMessagesInfo){
        return messageServices.getMessages(getMessagesInfo);
    }
}
