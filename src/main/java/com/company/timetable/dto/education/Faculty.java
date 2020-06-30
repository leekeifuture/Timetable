package com.company.timetable.dto.education;

import javax.persistence.Entity;
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
public class Faculty {

    @Id
    @ApiModelProperty(notes = "ID of faculty", position = 1)
    private Integer id;

    @NotBlank
    @ApiModelProperty(notes = "Title of faculty", position = 2)
    private String title;

    @ApiModelProperty(notes = "Is faculty allowed for using", position = 3)
    private Boolean isAllowed;

    @ManyToOne
    @JoinColumn(name = "education_id")
    @ApiModelProperty(notes = "University of faculty", position = 4)
    private Education education;
}
