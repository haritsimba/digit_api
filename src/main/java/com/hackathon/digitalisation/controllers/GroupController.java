package com.hackathon.digitalisation.controllers;

import com.hackathon.digitalisation.dtos.CreateGroupIn;
import com.hackathon.digitalisation.entitites.ChatGroup;
import com.hackathon.digitalisation.services.ChatGroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("group")
public class GroupController {
    ChatGroupService chatGroupService;

    @PostMapping("")
    public ChatGroup createGroup(@RequestBody CreateGroupIn groupInfo){
        return chatGroupService.createChatGroup(groupInfo);
    }
}
