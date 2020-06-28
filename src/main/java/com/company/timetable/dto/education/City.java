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
public class City {

    @Id
    @ApiModelProperty(notes = "ID of city", position = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @ApiModelProperty(notes = "Country of city", position = 2)
    private Country country;

    @NotBlank
    @ApiModelProperty(notes = "Title of city", position = 3)
    private String title;

    @ApiModelProperty(notes = "Is city allowed for using", position = 4)
    private Boolean isAllowed;
}
