package com.hackathon.digitalisation.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NotificationDTO {
    private String type; // MESSAGE, SCHEDULE, ANNOUNCEMENT
    private Object data;
}
