package com.hackathon.digitalisation.dtos;

import com.hackathon.digitalisation.entitites.ChatGroup;
import com.hackathon.digitalisation.entitites.TimeTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateScheduleOut {
    TimeTable schedule;
    ChatGroup group;
}
