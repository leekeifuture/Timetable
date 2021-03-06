package com.company.timetable.dto.education;

import javax.persistence.Entity;
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
public class Country {

    @Id
    @ApiModelProperty(notes = "ID of country", position = 1)
    private Integer id;

    @NotBlank
    @ApiModelProperty(notes = "Title of country", position = 2)
    private String title;

    @ApiModelProperty(notes = "Is country allowed for using", position = 3)
    private Boolean isAllowed;
}
