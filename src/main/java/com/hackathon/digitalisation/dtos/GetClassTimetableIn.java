package com.hackathon.digitalisation.dtos;

import com.hackathon.digitalisation.enums.LevelType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GetClassTimetableIn {
    String school;
    String department;
    LevelType level;
}
