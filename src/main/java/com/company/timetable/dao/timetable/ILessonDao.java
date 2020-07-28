package com.company.timetable.dao.timetable;

import com.company.timetable.dto.timetable.Lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILessonDao extends JpaRepository<Lesson, Integer> {
}
