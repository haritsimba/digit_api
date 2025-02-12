package com.hackathon.digitalisation.dtos;

import com.hackathon.digitalisation.enums.LevelType;

public record RegisterStudentIn(
        String name,
        String surname,
        String password,
        String matricule,
        String telephone,
        String email,
        String school,
        String department,
        LevelType level,
        String pictureUri
) {
}