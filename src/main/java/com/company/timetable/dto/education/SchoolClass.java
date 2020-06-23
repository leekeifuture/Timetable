package com.company.timetable.dto.education;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClass {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "ID of school class", position = 1)
    private Integer id;

    @NotBlank
    @ApiModelProperty(notes = "Title of school class", position = 2)
    private String title;
}
