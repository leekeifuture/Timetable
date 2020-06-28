package com.company.timetable.dao.education;

import com.company.timetable.dto.education.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityDao extends JpaRepository<City, Integer> {
}
