package com.hackathon.digitalisation.entitites;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "evenement")
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long Id;
    @Lob
    @Column(name = "long_description")
    String content;
    Date start;
    Date end;
}
