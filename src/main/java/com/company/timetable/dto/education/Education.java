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
public class Education {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "ID of education", position = 1)
    private Integer id;

    @NotBlank
    @ApiModelProperty(notes = "Title of education", position = 2)
    private String title;
}
