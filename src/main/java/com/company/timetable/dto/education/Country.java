package com.company.timetable.dto.education;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
public class Country {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "ID of country", position = 1)
    private Long id;

    @NotBlank
    @ApiModelProperty(notes = "Title of country", position = 2)
    private String title;
}
