package com.company.timetable.service;

import com.company.timetable.dao.timetable.IClassroomDao;
import com.company.timetable.dao.timetable.ILessonDao;
import com.company.timetable.dao.timetable.ISubjectDao;
import com.company.timetable.dao.timetable.ITeacherDao;
import com.company.timetable.dao.timetable.ITimetableDao;
import com.company.timetable.dto.timetable.Classroom;
import com.company.timetable.dto.timetable.Lesson;
import com.company.timetable.dto.timetable.Subject;
import com.company.timetable.dto.timetable.Teacher;
import com.company.timetable.dto.timetable.Timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableService implements ITimetableService {

    @Autowired
    private ITimetableDao iTimetableDao;
    @Autowired
    private ILessonDao iLessonDao;
    @Autowired
    private ISubjectDao iSubjectDao;
    @Autowired
    private ITeacherDao iTeacherDao;
    @Autowired
    private IClassroomDao iClassroomDao;

    @Override
    public Timetable createTimetable(Timetable timetable) {
        Timetable newTimetable = iTimetableDao.save(timetable);
        return newTimetable;
    }

    @Override
    public Lesson createLesson(Lesson lesson) {
        Lesson newLesson = iLessonDao.save(lesson);
        return newLesson;
    }

    @Override
    public Subject createSubject(Subject subject) {
        Subject newSubject = iSubjectDao.save(subject);
        return newSubject;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        Teacher newTeacher = iTeacherDao.save(teacher);
        return newTeacher;
    }

    @Override
    public Classroom createClassroom(Classroom classroom) {
        Classroom newClassroom = iClassroomDao.save(classroom);
        return newClassroom;
    }
}
