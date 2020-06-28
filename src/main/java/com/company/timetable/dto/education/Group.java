package com.company.timetable.dto.education;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "grp")
public class Group {

    @Id
    @ApiModelProperty(notes = "ID of group", position = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    @ApiModelProperty(notes = "Group of faculty", position = 2)
    private Faculty faculty;

    @NotBlank
    @ApiModelProperty(notes = "Title of group", position = 3)
    private String title;
}
