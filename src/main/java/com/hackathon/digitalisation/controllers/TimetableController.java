package com.hackathon.digitalisation.controllers;

import com.hackathon.digitalisation.dtos.AddTimeTableIn;
import com.hackathon.digitalisation.dtos.CreateScheduleOut;
import com.hackathon.digitalisation.dtos.GetClassTimetableIn;
import com.hackathon.digitalisation.entitites.TimeTable;
import com.hackathon.digitalisation.services.TimetableService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("schedule")
@AllArgsConstructor
public class TimetableController {

    TimetableService timetableService;

    @PostMapping("")
    public ResponseEntity<CreateScheduleOut> addSchedule(@RequestBody AddTimeTableIn schedule){
        return timetableService.addSubject(schedule);
    }

    @GetMapping("teacher/{teacherId}")
    public ResponseEntity<List<TimeTable>> getTeacherSchedule(@PathVariable Long teacherId){
        return timetableService.getTeacherTimetable(teacherId);
    }

    @PostMapping("student")
    public ResponseEntity<List<TimeTable>> getTeacherSchedule(@RequestBody GetClassTimetableIn student){
        return timetableService.getClassTimetable(student);
    }
}
