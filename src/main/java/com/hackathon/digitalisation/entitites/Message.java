package com.hackathon.digitalisation.entitites;

import com.hackathon.digitalisation.enums.MessageType;
import com.hackathon.digitalisation.enums.RecipientType;
import com.hackathon.digitalisation.enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long Id;
    Long fromId;
    String content;
    @Enumerated(value = EnumType.STRING)
    UserType fromType;
    Long recipientId;
    @Enumerated(value = EnumType.STRING)
    RecipientType recipientType;
    String link;
    @Enumerated(value = EnumType.STRING)
    MessageType type;
    @CreationTimestamp
    Date creation;
}
