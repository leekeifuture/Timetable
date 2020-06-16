package com.company.timetable.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private Long telegramId;
    private Long countryId;
    private Long cityId;
    private Long eduTypeId;
    private Long eduId;
    private Long schoolClassId;
    private Long classLetterId;
    private Long facultyId;
    private Long groupId;
    private Long adminRoleId;
}
