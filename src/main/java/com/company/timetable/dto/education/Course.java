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
public class Course {

    @Id
    @ApiModelProperty(notes = "ID of course", position = 1)
    private Integer id;

    @ApiModelProperty(notes = "Title of course", position = 2)
    private Integer title;
}
