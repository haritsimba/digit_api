package com.hackathon.digitalisation.entitites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String fileName;
    String fileType;

    @Lob
    byte[] fileData;
}
