package com.hackathon.digitalisation.dtos;

import com.hackathon.digitalisation.enums.MessageType;
import com.hackathon.digitalisation.enums.RecipientType;
import com.hackathon.digitalisation.enums.UserType;

public record SendMessageIn(
        String content,
        MessageType type,
        Long from,
        UserType fromType,
        Long to,
        String attachmentLink,
        RecipientType recipientType
) {
}
