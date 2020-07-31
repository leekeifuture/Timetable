package com.company.timetable.dao.timetable;

import com.company.timetable.dto.timetable.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherDao extends JpaRepository<Teacher, Integer> {
}
