package com.company.timetable.dto.timetable;

import com.company.timetable.dto.User;
import com.company.timetable.dto.education.Group;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Timetable {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "ID of group timetable", position = 1)
    private Integer id;

    @OneToMany
    @ApiModelProperty(notes = "Monday timetable", position = 2)
    private List<Lesson> mondayLessons;

    @OneToMany
    @ApiModelProperty(notes = "Tuesday timetable", position = 3)
    private List<Lesson> tuesdayLessons;

    @OneToMany
    @ApiModelProperty(notes = "Wednesday timetable", position = 4)
    private List<Lesson> wednesdayLessons;

    @OneToMany
    @ApiModelProperty(notes = "Thursday timetable", position = 5)
    private List<Lesson> thursdayLessons;

    @OneToMany
    @ApiModelProperty(notes = "Friday timetable", position = 6)
    private List<Lesson> fridayLessons;

    @OneToMany
    @ApiModelProperty(notes = "Saturday timetable", position = 7)
    private List<Lesson> saturdayLessons;

    @OneToMany
    @ApiModelProperty(notes = "Sunday timetable", position = 8)
    private List<Lesson> sundayLessons;

    @ApiModelProperty(notes = "Rating of timetable", position = 9)
    private TimetableRating rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ApiModelProperty(notes = "Author of timetable", position = 10)
    private User author;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @ApiModelProperty(notes = "Group of timetable", position = 11)
    private Group group;
}
