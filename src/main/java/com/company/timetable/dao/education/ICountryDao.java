package com.company.timetable.dao.education;

import com.company.timetable.dto.education.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryDao extends JpaRepository<Country, Integer> {
}
