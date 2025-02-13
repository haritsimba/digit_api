package com.hackathon.digitalisation.entitites;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackathon.digitalisation.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long Id;
    String name;
    String surname;
    String picture;
    @JsonIgnore
    String password;
    String matricule;
    String email;
    String phone;
    @Enumerated(value = EnumType.STRING)
    UserType type;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"students","teacher"})
    List<ChatGroup> chatGroups = new ArrayList<>();

}
