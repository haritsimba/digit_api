package com.hackathon.digitalisation.dtos;

import com.hackathon.digitalisation.enums.RecipientType;

public record GetMessagesIn(
        Long chatId,
        String chatType,
        Long before){ }
