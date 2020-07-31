package com.company.timetable.controller;

import com.company.timetable.dto.timetable.Classroom;
import com.company.timetable.dto.timetable.Lesson;
import com.company.timetable.dto.timetable.Subject;
import com.company.timetable.dto.timetable.Teacher;
import com.company.timetable.dto.timetable.Timetable;
import com.company.timetable.service.TimetableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1/timetable", produces = "application/json")
@Api(description = "Timetable controller")
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @PostMapping("/")
    @ApiOperation(value = "Create new timetable")
    public ResponseEntity<Timetable> createTimetable(
            @RequestBody Timetable timetable
    ) {
        Timetable newTimetable = timetableService.createTimetable(timetable);
        return new ResponseEntity<>(newTimetable, HttpStatus.OK);
    }

    @PostMapping("/lesson")
    @ApiOperation(value = "Create new lesson")
    public ResponseEntity<Lesson> createLesson(
            @RequestBody Lesson lesson
    ) {
        Lesson newLesson = timetableService.createLesson(lesson);
        return new ResponseEntity<>(newLesson, HttpStatus.OK);
    }

    @PostMapping("/subject")
    @ApiOperation(value = "Create new subject")
    public ResponseEntity<Subject> createSubject(
            @RequestBody Subject subject
    ) {
        Subject newSubject = timetableService.createSubject(subject);
        return new ResponseEntity<>(newSubject, HttpStatus.OK);
    }

    @PostMapping("/teacher")
    @ApiOperation(value = "Create new teacher")
    public ResponseEntity<Teacher> createTeacher(
            @RequestBody Teacher teacher
    ) {
        Teacher newTeacher = timetableService.createTeacher(teacher);
        return new ResponseEntity<>(newTeacher, HttpStatus.OK);
    }

    @PostMapping("/classroom")
    @ApiOperation(value = "Create new classroom")
    public ResponseEntity<Classroom> createClassroom(
            @RequestBody Classroom classroom
    ) {
        Classroom newClassroom = timetableService.createClassroom(classroom);
        return new ResponseEntity<>(newClassroom, HttpStatus.OK);
    }
}
