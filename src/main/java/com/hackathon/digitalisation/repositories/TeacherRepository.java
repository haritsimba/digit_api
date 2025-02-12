package com.hackathon.digitalisation.repositories;

import com.hackathon.digitalisation.entitites.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    public Teacher getTeachersByEmailAndPassword(String email,String password);
}
