package com.company.timetable.dto;

import com.company.timetable.dto.education.City;
import com.company.timetable.dto.education.ClassLetter;
import com.company.timetable.dto.education.Country;
import com.company.timetable.dto.education.Education;
import com.company.timetable.dto.education.EducationType;
import com.company.timetable.dto.education.Faculty;
import com.company.timetable.dto.education.Group;
import com.company.timetable.dto.education.SchoolClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "Generated DB ID of user", position = 1)
    private Integer id;
    @ApiModelProperty(notes = "Telegram ID of user", position = 2)
    private Integer telegramId;
    @ManyToOne
    @JoinColumn(name = "country")
    @ApiModelProperty(notes = "Selected country", position = 3)
    private Country country;
    @ManyToOne
    @JoinColumn(name = "city")
    @ApiModelProperty(notes = "Selected city", position = 4)
    private City city;
    @ManyToOne
    @JoinColumn(name = "education_type")
    @ApiModelProperty(notes = "Selected education type", position = 5)
    private EducationType educationType;
    @ManyToOne
    @JoinColumn(name = "education")
    @ApiModelProperty(notes = "Selected education", position = 6)
    private Education education;
    @ManyToOne
    @JoinColumn(name = "school_class")
    @ApiModelProperty(notes = "Selected school class", position = 7)
    private SchoolClass schoolClass;
    @ManyToOne
    @JoinColumn(name = "class_letter")
    @ApiModelProperty(notes = "Selected class letter", position = 8)
    private ClassLetter classLetter;
    @ManyToOne
    @JoinColumn(name = "faculty")
    @ApiModelProperty(notes = "Selected faculty", position = 9)
    private Faculty faculty;
    @ManyToOne
    @JoinColumn(name = "group")
    @ApiModelProperty(notes = "Selected group", position = 10)
    private Group group;
}
