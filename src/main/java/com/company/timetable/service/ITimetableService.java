package com.company.timetable.service;

import com.company.timetable.dto.timetable.Classroom;
import com.company.timetable.dto.timetable.Lesson;
import com.company.timetable.dto.timetable.Subject;
import com.company.timetable.dto.timetable.Teacher;
import com.company.timetable.dto.timetable.Timetable;

public interface ITimetableService {
    Timetable createTimetable(Timetable timetable);

    Lesson createLesson(Lesson lesson);

    Subject createSubject(Subject subject);

    Teacher createTeacher(Teacher teacher);

    Classroom createClassroom(Classroom classroom);
}
