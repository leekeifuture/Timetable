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
public class Education {

    @Id
    @ApiModelProperty(notes = "ID of education", position = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @ApiModelProperty(notes = "City of education", position = 2)
    private City city;

    @ManyToOne
    @JoinColumn(name = "education_type_id")
    @ApiModelProperty(notes = "City of education", position = 3)
    private EducationType educationType;

    @NotBlank
    @ApiModelProperty(notes = "Title of education", position = 4)
    private String title;

    @ApiModelProperty(notes = "Is education allowed for using", position = 5)
    private Boolean isAllowed;
}
