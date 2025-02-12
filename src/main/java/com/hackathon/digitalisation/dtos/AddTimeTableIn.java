package com.hackathon.digitalisation.dtos;

import com.hackathon.digitalisation.enums.LevelType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddTimeTableIn {
    String subject;
    String day;
    LocalTime start;
    LocalTime end;
    Long teacherId;
    String school;
    String department;
    LevelType level;
    String groupName;
}
