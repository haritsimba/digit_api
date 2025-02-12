package com.hackathon.digitalisation.repositories;

import com.hackathon.digitalisation.entitites.TimeTable;
import com.hackathon.digitalisation.enums.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeTableRepository extends JpaRepository<TimeTable,Long> {
    public List<TimeTable> getTimeTableByTeacherId(Long id);
    public List<TimeTable> getTimeTableBySchoolAndDepartmentAndLevel(String school, String department, LevelType level);
}
