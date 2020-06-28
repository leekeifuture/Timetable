package com.company.timetable.dao.education;

import com.company.timetable.dto.education.EducationType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationTypeDao extends JpaRepository<EducationType, Integer> {

    EducationType findByTitle(String title);
}
