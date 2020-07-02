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
public class Subject {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "ID of subject", position = 1)
    private Integer id;

    @NotBlank
    @ApiModelProperty(notes = "Title of subject", position = 2)
    private String title;

    @ManyToOne
    @JoinColumn(name = "education_id")
    @ApiModelProperty(notes = "Education institution of subject", position = 3)
    private Education education;
}
