package com.hackathon.digitalisation.entitites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackathon.digitalisation.enums.LevelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "chat_groups")
public class ChatGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;
    String groupName;
    String groupSubject;
    @Enumerated(value = EnumType.STRING)
    LevelType groupLevel;
    String groupSchool;
    String groupDepartment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties({"password", "matricule","email","phone","chatGroups"})
    private Teacher teacher;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "chat_group_student",
            joinColumns = @JoinColumn(name = "chat_group_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonIgnoreProperties({"password", "matricule","email","phone","chatGroups","school","department","level"})
    Set<Student> students = new HashSet<>();
}