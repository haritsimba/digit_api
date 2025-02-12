package com.hackathon.digitalisation.services;

import com.hackathon.digitalisation.dtos.CreateGroupIn;
import com.hackathon.digitalisation.entitites.ChatGroup;
import com.hackathon.digitalisation.entitites.Student;
import com.hackathon.digitalisation.entitites.Teacher;
import com.hackathon.digitalisation.repositories.ChatGroupRepository;
import com.hackathon.digitalisation.repositories.StudentRepository;
import com.hackathon.digitalisation.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class ChatGroupService {
    ChatGroupRepository chatGroupRepository;
    TeacherRepository teacherRepository;
    StudentRepository studentRepository;
    public ChatGroup createChatGroup(CreateGroupIn groupInfo){
        ChatGroup group = new ChatGroup();
        group.setGroupName(groupInfo.groupName());
        group.setGroupSubject(groupInfo.groupSubject());
        group.setGroupSchool(groupInfo.groupSchool());
        group.setGroupDepartment(groupInfo.groupDepartment());
        group.setGroupLevel(groupInfo.groupLevel());

        Teacher groupTeacher = getTeacher(groupInfo.teacherId());
        Set<Student> students = getStudentBySDL(group);

        group.setTeacher(groupTeacher);
        group.setStudents(students);

        return chatGroupRepository.save(group);

    }

    private Set<Student> getStudentBySDL(ChatGroup group){
        return studentRepository.getStudentBySchoolAndDepartmentAndLevel(group.getGroupSchool(),group.getGroupDepartment(),group.getGroupLevel());
    }

    private Teacher getTeacher(Long id){
        return teacherRepository.findById(id).orElseThrow();
    }
}