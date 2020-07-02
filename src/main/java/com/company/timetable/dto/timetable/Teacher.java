package com.company.timetable.dto.timetable;

import com.company.timetable.dto.education.Education;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "ID of teacher", position = 1)
    private Integer id;

    @NotBlank
    @ApiModelProperty(notes = "Name of teacher", position = 2)
    private String name;

    @NotBlank
    @ApiModelProperty(notes = "Surname of teacher", position = 3)
    private String surname;

    @ApiModelProperty(notes = "Patronymic of teacher", position = 4)
    private String patronymic;

    @ManyToOne
    @JoinColumn(name = "education_id")
    @ApiModelProperty(notes = "Education institution of teacher", position = 5)
    private Education education;
}
