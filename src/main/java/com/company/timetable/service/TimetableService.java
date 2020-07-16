package com.company.timetable.service;

import com.company.timetable.dao.timetable.ITimetableDao;
import com.company.timetable.dto.timetable.Timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableService {

    @Autowired
    private ITimetableDao iTimetableDao;

    public Timetable createTimetable(Timetable timetable) {
        Timetable newTimetable = iTimetableDao.save(timetable);
        return newTimetable;
    }
}
