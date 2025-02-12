package com.hackathon.digitalisation.dtos;

import com.hackathon.digitalisation.enums.LevelType;

public record CreateGroupIn(
        String groupName,
        String groupSubject,
        Long teacherId,
        String groupSchool,
        String groupDepartment,
        LevelType groupLevel
) {
}
