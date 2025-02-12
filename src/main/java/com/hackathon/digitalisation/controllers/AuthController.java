package com.hackathon.digitalisation.controllers;

import com.hackathon.digitalisation.dtos.LoginIn;
import com.hackathon.digitalisation.dtos.RegisterStudentIn;
import com.hackathon.digitalisation.dtos.RegisterTeacherIn;
import com.hackathon.digitalisation.entitites.Student;
import com.hackathon.digitalisation.entitites.Teacher;
import com.hackathon.digitalisation.services.StudentSevice;
import com.hackathon.digitalisation.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthController {

    StudentSevice studentSevice;
    TeacherService teacherService;
    @PostMapping(path = "login")
    public ResponseEntity loginStudent(@RequestBody LoginIn login){
        ResponseEntity<Teacher> teacherLogin = teacherService.doTeacherLogin(login);
        if(teacherLogin.getStatusCode().is2xxSuccessful() && teacherLogin.getBody()!=null){
            return teacherLogin;
        }
        return studentSevice.doStudentLogin(login);
    }

    @PostMapping(path = "register/student")
    public ResponseEntity<Student> registerStudent(@RequestBody RegisterStudentIn register){
        return studentSevice.registerStudent(register);
    }

    @PostMapping(path = "register/teacher")
    public ResponseEntity<Teacher> registerTeacher(@RequestBody RegisterTeacherIn register){
        return teacherService.registerTeacher(register);
    }
}
