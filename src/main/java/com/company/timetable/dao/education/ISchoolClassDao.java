package com.company.timetable.dao.education;

import com.company.timetable.dto.education.SchoolClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISchoolClassDao extends JpaRepository<SchoolClass, Integer> {
}
