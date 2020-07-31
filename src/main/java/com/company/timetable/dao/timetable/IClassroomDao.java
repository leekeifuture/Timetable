package com.company.timetable.dao.timetable;

import com.company.timetable.dto.timetable.Classroom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassroomDao extends JpaRepository<Classroom, Integer> {
}
