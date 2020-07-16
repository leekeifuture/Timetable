package com.company.timetable.dao.timetable;

import com.company.timetable.dto.timetable.Timetable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITimetableDao extends JpaRepository<Timetable, Integer> {
}
