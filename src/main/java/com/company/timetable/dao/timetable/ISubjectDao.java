package com.company.timetable.dao.timetable;

import com.company.timetable.dto.timetable.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectDao extends JpaRepository<Subject, Integer> {
}
