package com.company.timetable.dto.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TelegramAccount {

    @Id
    @ApiModelProperty(notes = "Telegram ID of user", position = 1)
    private Integer id;

    @ApiModelProperty(notes = "Telegram first name of user", position = 2)
    private String firstName;

    @ApiModelProperty(notes = "Telegram username of user", position = 3)
    private String username;

    @ApiModelProperty(notes = "Telegram photo url of user", position = 4)
    private String photoUrl;

    @ApiModelProperty(notes = "Telegram last auth date of user", position = 5)
    private Date authDate;

    @ApiModelProperty(notes = "Hash of telegram account fields", position = 6)
    private String hash;

    @Override
    public String toString() {
        return "auth_date=" + authDate.getTime() + "\n" +
                "first_name=" + firstName + "\n" +
                "id=" + id + "\n" +
                "photo_url=" + photoUrl + "\n" +
                "username=" + username;
    }
}
