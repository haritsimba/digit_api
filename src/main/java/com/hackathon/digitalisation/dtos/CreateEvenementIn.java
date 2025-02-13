package com.hackathon.digitalisation.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

import java.util.Date;

public record CreateEvenementIn(
        String content,
        String title,
        String attachmentLink,
        String start,
        String end) {}
