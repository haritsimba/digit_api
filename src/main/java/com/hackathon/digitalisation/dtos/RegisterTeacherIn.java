package com.hackathon.digitalisation.dtos;

public record RegisterTeacherIn(
        String name,
        String surname,
        String password,
        String email,
        String phone,
        String matricule,
        String pictureUri
) {
}