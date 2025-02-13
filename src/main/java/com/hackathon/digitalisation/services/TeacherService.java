package com.hackathon.digitalisation.services;

import com.hackathon.digitalisation.dtos.LoginIn;
import com.hackathon.digitalisation.dtos.RegisterTeacherIn;
import com.hackathon.digitalisation.entitites.Teacher;
import com.hackathon.digitalisation.enums.UserType;
import com.hackathon.digitalisation.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TeacherService {

    TeacherRepository teacherRepository;

    public ResponseEntity<Teacher> registerTeacher(RegisterTeacherIn teacherInfo){
        Teacher teacher = new Teacher();
        teacher.setName(teacherInfo.name());
        teacher.setSurname(teacherInfo.surname());
        teacher.setMatricule(teacherInfo.matricule());
        teacher.setEmail(teacherInfo.email());
        teacher.setPhone(teacherInfo.phone());
        teacher.setPassword(teacherInfo.password());
        teacher.setType(UserType.TEACHER);
        teacher.setPicture(teacherInfo.pictureUri());

        Teacher teacherRes = teacherRepository.save(teacher);
        return ResponseEntity.ok().body(teacherRes);
    }

    public ResponseEntity<Teacher> doTeacherLogin(LoginIn loginInfo){
        Teacher teacher = teacherRepository.getTeachersByEmailAndPassword(loginInfo.email(), loginInfo.password());
        return ResponseEntity.ok().body(teacher);
    }
    public Teacher getTeacherById(Long id){
        return teacherRepository.findById(id).orElse(null);
    }
}
