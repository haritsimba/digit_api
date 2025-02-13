package com.hackathon.digitalisation.repositories;

import com.hackathon.digitalisation.entitites.ChatGroup;
import com.hackathon.digitalisation.enums.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ChatGroupRepository extends JpaRepository<ChatGroup,Long> {
    public Set<ChatGroup> getChatGroupByGroupSchoolAndGroupDepartmentAndGroupLevel(String school, String department, LevelType level);
    public Set<ChatGroup> getChatGroupByTeacherId(Long teacherId);

    Long id(Long id);
}
