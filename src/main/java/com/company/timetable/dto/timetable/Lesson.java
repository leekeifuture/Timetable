package com.company.timetable.dto.timetable;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "ID of lesson", position = 1)
    private Integer id;

    @NotBlank
    @ApiModelProperty(notes = "Serial number of lesson", position = 2)
    private Integer serialNumber;

    @NotBlank
    @ApiModelProperty(notes = "First start of lesson", position = 3)
    private Date firstStart;

    @ApiModelProperty(notes = "First end of lesson", position = 4)
    private Date firstEnd;

    @ApiModelProperty(notes = "Second start of lesson", position = 5)
    private Date secondStart;

    @NotBlank
    @ApiModelProperty(notes = "Second end of lesson", position = 6)
    private Date secondEnd;

    @OneToMany
    @ApiModelProperty(notes = "Subject / list of subjects", position = 7)
    private List<Subject> subjects;

    @OneToMany
    @ApiModelProperty(notes = "Teacher / list of teachers", position = 8)
    private List<Teacher> teachers;

    @OneToMany
    @ApiModelProperty(notes = "Classroom / list of classrooms", position = 9)
    private List<Classroom> classrooms;
}
