package com.company.timetable.dao.education;

import com.company.timetable.dto.education.Faculty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacultyDao extends JpaRepository<Faculty, Integer> {
}
