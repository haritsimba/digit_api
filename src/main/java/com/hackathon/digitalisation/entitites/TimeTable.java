package com.hackathon.digitalisation.entitites;

import com.hackathon.digitalisation.enums.LevelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "time_table")
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long Id;
    String subject;
    LocalTime start;
    LocalTime end;
    String day;
    Long teacherId;
    String teacherName;
    String school;
    String department;
    LevelType level;
}
