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
public class ClassLetter {

    @Id
    @ApiModelProperty(notes = "ID of class letter", position = 1)
    private Integer id;

    @NotBlank
    @ApiModelProperty(notes = "Title of class letter", position = 2)
    private String title;
}
