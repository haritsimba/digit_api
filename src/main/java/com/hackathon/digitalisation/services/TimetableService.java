package com.hackathon.digitalisation.services;

import com.hackathon.digitalisation.dtos.AddTimeTableIn;
import com.hackathon.digitalisation.dtos.CreateGroupIn;
import com.hackathon.digitalisation.dtos.CreateScheduleOut;
import com.hackathon.digitalisation.dtos.GetClassTimetableIn;
import com.hackathon.digitalisation.entitites.ChatGroup;
import com.hackathon.digitalisation.entitites.Student;
import com.hackathon.digitalisation.entitites.Teacher;
import com.hackathon.digitalisation.entitites.TimeTable;
import com.hackathon.digitalisation.repositories.ChatGroupRepository;
import com.hackathon.digitalisation.repositories.StudentRepository;
import com.hackathon.digitalisation.repositories.TeacherRepository;
import com.hackathon.digitalisation.repositories.TimeTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class TimetableService {
    TimeTableRepository timeTableRepository;
    ChatGroupRepository chatGroupRepository;
    StudentRepository studentRepository;
    TeacherRepository teacherRepository;

    public ResponseEntity<CreateScheduleOut> addSubject(AddTimeTableIn timeTableIn){

        TimeTable timeTable = new TimeTable();
        timeTable.setSubject(timeTableIn.getSubject());
        timeTable.setTeacherId(timeTableIn.getTeacherId());
        timeTable.setDay(timeTableIn.getDay());
        timeTable.setStart(timeTableIn.getStart());
        timeTable.setEnd(timeTableIn.getEnd());
        timeTable.setSchool(timeTableIn.getSchool());
        timeTable.setDepartment(timeTableIn.getDepartment());
        timeTable.setLevel(timeTableIn.getLevel());


            String group = timeTableIn.getGroupName() == null ? timeTableIn.getSubject() : timeTableIn.getGroupName();



        System.out.println(timeTable);

        TimeTable savedTimeTable = timeTableRepository.save(timeTable);
        ChatGroup createdGroup = createChatGroup(new CreateGroupIn(group,timeTableIn.getSubject(), savedTimeTable.getTeacherId(), savedTimeTable.getSchool(), savedTimeTable.getDepartment(), savedTimeTable.getLevel()));
        return ResponseEntity.ok().body(new CreateScheduleOut(savedTimeTable,createdGroup));
    }

    private ChatGroup createChatGroup(CreateGroupIn groupInfo){
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
    public ResponseEntity<List<TimeTable>> getClassTimetable(GetClassTimetableIn timetableSelector){
        List<TimeTable> timeTables = timeTableRepository.getTimeTableBySchoolAndDepartmentAndLevel(timetableSelector.getSchool(),timetableSelector.getDepartment(),timetableSelector.getLevel());
        return ResponseEntity.ok().body(timeTables);
    }

    public ResponseEntity<List<TimeTable>> getTeacherTimetable(Long teacherId){
        List<TimeTable> timeTables = timeTableRepository.getTimeTableByTeacherId(teacherId);
        return ResponseEntity.ok().body(timeTables);
    }
}
