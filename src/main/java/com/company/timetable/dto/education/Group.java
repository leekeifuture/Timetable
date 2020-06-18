package com.company.timetable.dto.education;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "grp")
public class Group {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "ID of group", position = 1)
    private Long id;

    @NotBlank
    @ApiModelProperty(notes = "Title of group", position = 2)
    private String title;
}
