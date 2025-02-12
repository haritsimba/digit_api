package com.hackathon.digitalisation.entitites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackathon.digitalisation.enums.LevelType;
import com.hackathon.digitalisation.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long Id;
    String name;
    String surname;
    @JsonIgnore
    String password;
    String matricule;
    String email;
    String phone;
    String picture;
    @Enumerated(value = EnumType.STRING)
    UserType type;
    String school;
    @Enumerated(value = EnumType.STRING)
    LevelType level;
    String department;
    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"students","teacher","groupLevel","groupSchool","groupDepartment","school","department","level"})
    Set<ChatGroup> chatGroups = new HashSet<>();
}