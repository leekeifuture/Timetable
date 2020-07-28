package com.company.timetable.controller;

import com.company.timetable.dto.timetable.Lesson;
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
    public ResponseEntity<Lesson> createWeekLesson(
            @RequestBody Lesson lesson
    ) {
        Lesson newLesson = timetableService.createWeekLesson(lesson);
        return new ResponseEntity<>(newLesson, HttpStatus.OK);
    }
}
