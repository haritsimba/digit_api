package com.hackathon.digitalisation.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "evenement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long Id;
    @Lob
    @Column(name = "long_description")
    String content;
    String title;
    String attachmentLink;
    Date start;
    Date end;
}
