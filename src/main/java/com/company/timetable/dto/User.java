package com.company.timetable.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "Generated DB ID of user", position = 1)
    private Long id;
    @ApiModelProperty(notes = "Telegram ID of user", position = 2)
    private Long telegramId;
    @ApiModelProperty(notes = "ID of selected country", position = 3)
    private Long countryId;
    @ApiModelProperty(notes = "ID of selected city", position = 4)
    private Long cityId;
    @ApiModelProperty(notes = "ID of selected education type", position = 5)
    private Long eduTypeId;
    @ApiModelProperty(notes = "ID of selected education", position = 6)
    private Long eduId;
    @ApiModelProperty(notes = "ID of selected school class", position = 7)
    private Long schoolClassId;
    @ApiModelProperty(notes = "ID of selected class letter", position = 8)
    private Long classLetterId;
    @ApiModelProperty(notes = "ID of selected faculty", position = 9)
    private Long facultyId;
    @ApiModelProperty(notes = "ID of selected group", position = 10)
    private Long groupId;
    @ApiModelProperty(notes = "Admin role ID", position = 11)
    private Long adminRoleId;
}
