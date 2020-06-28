package com.company.timetable.dao.education;

import com.company.timetable.dto.education.Education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDao extends JpaRepository<Education, Integer> {
}
