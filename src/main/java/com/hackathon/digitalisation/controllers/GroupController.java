package com.hackathon.digitalisation.controllers;

import com.hackathon.digitalisation.dtos.CreateGroupIn;
import com.hackathon.digitalisation.entitites.ChatGroup;
import com.hackathon.digitalisation.services.ChatGroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("group")
public class GroupController {
    ChatGroupService chatGroupService;

    @GetMapping("{teacherId}")
    public Set<ChatGroup> createGroup(@PathVariable("teacherId") Long id){
        return chatGroupService.getTeacherGroups(id);
    }
}