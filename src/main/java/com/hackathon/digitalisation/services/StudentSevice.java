package com.hackathon.digitalisation.services;

import com.hackathon.digitalisation.dtos.LoginIn;
import com.hackathon.digitalisation.dtos.RegisterStudentIn;
import com.hackathon.digitalisation.entitites.ChatGroup;
import com.hackathon.digitalisation.entitites.Student;
import com.hackathon.digitalisation.enums.UserType;
import com.hackathon.digitalisation.repositories.ChatGroupRepository;
import com.hackathon.digitalisation.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class StudentSevice {

    StudentRepository studentRepository;

    ChatGroupRepository chatGroupRepository;

    public ResponseEntity<Student> registerStudent(RegisterStudentIn studentInfo){
        Student student = new Student();
        student.setName(studentInfo.name());
        student.setSurname(studentInfo.surname());
        student.setEmail(studentInfo.email());
        student.setPhone(studentInfo.telephone());
        student.setPassword(studentInfo.password());
        student.setMatricule(studentInfo.matricule());
        student.setSchool(studentInfo.school());
        student.setDepartment(studentInfo.department());
        student.setLevel(studentInfo.level());
        student.setType(UserType.STUDENT);
        student.setPicture(studentInfo.pictureUri());

        Student savedStudent = studentRepository.save(student);

        System.out.println(savedStudent.toString());
        Set<ChatGroup> studentGroups = getGroupChatBelongToStudent(savedStudent);

        if (!studentGroups.isEmpty()) {
            studentGroups.forEach(group -> group.getStudents().add(savedStudent));
            chatGroupRepository.saveAll(studentGroups);
        }

        savedStudent.setChatGroups(studentGroups);
        return ResponseEntity.ok().body(savedStudent);
    }

    private Set<ChatGroup> getGroupChatBelongToStudent(Student student){
        return chatGroupRepository.
                getChatGroupByGroupSchoolAndGroupDepartmentAndGroupLevel(
                student.getSchool(),
                student.getDepartment(),
                student.getLevel());
    }

    public ResponseEntity<Student> doStudentLogin(LoginIn loginInfo){
        Student student = studentRepository.getStudentByEmailAndPassword(loginInfo.email(), loginInfo.password());
        return ResponseEntity.ok().body(student);
    }
}
