package com.company.timetable.controller;

import com.company.timetable.dto.user.TelegramAccount;
import com.company.timetable.service.SignUpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1/sign/up", produces = "application/json")
@Api(description = "SignUp controller")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping("/telegram")
    @ApiOperation(value = "SignUp telegram account")
    public ResponseEntity signUpTelegramAccount(@RequestBody TelegramAccount telegramAccount) {
        Boolean isSignedUp = signUpService.signUpTelegramAccount(telegramAccount);
        if (isSignedUp) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }
}
