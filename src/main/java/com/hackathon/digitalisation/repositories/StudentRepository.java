package com.hackathon.digitalisation.repositories;

import com.hackathon.digitalisation.entitites.Student;
import com.hackathon.digitalisation.enums.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface StudentRepository extends JpaRepository<Student,Long> {
    public Student getStudentByEmailAndPassword(String email,String password);
    public Set<Student> getStudentBySchoolAndDepartmentAndLevel(String school, String department, LevelType level);
}
