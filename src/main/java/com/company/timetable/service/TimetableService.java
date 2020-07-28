package com.company.timetable.service;

import com.company.timetable.dao.timetable.ILessonDao;
import com.company.timetable.dao.timetable.ITimetableDao;
import com.company.timetable.dto.timetable.Lesson;
import com.company.timetable.dto.timetable.Timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableService {

    @Autowired
    private ITimetableDao iTimetableDao;
    @Autowired
    private ILessonDao iLessonDao;

    public Timetable createTimetable(Timetable timetable) {
        Timetable newTimetable = iTimetableDao.save(timetable);
        return newTimetable;
    }

    public Lesson createWeekLesson(Lesson lesson) {
        Lesson newLesson = iLessonDao.save(lesson);
        return newLesson;
    }
}
