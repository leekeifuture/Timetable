package com.company.timetable.dao.education;

import com.company.timetable.dto.education.Group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupDao extends JpaRepository<Group, Integer> {
}
