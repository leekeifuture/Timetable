package com.company.timetable.dto.user;

import com.company.timetable.dto.education.City;
import com.company.timetable.dto.education.ClassLetter;
import com.company.timetable.dto.education.Country;
import com.company.timetable.dto.education.Course;
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
    @ApiModelProperty(notes = "ID of user", position = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "telegram_account_id")
    @ApiModelProperty(notes = "Telegram account of user", position = 2)
    private TelegramAccount telegramAccount;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @ApiModelProperty(notes = "Selected country", position = 3)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @ApiModelProperty(notes = "Selected city", position = 4)
    private City city;

    @ManyToOne
    @JoinColumn(name = "education_type_id")
    @ApiModelProperty(notes = "Selected education type", position = 5)
    private EducationType educationType;

    @ManyToOne
    @JoinColumn(name = "education_id")
    @ApiModelProperty(notes = "Selected education", position = 6)
    private Education education;

    @ManyToOne
    @JoinColumn(name = "school_class_id")
    @ApiModelProperty(notes = "Selected school class", position = 7)
    private SchoolClass schoolClass;

    @ManyToOne
    @JoinColumn(name = "class_letter_id")
    @ApiModelProperty(notes = "Selected class letter", position = 8)
    private ClassLetter classLetter;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    @ApiModelProperty(notes = "Selected faculty", position = 9)
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @ApiModelProperty(notes = "Selected course", position = 10)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @ApiModelProperty(notes = "Selected group", position = 11)
    private Group group;
}
