package com.company.timetable.dao.education;

import com.company.timetable.dto.education.ClassLetter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassLetterDao extends JpaRepository<ClassLetter, Integer> {
}
