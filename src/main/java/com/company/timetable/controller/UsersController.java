package com.company.timetable.controller;

import com.company.timetable.dto.User;
import com.company.timetable.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
@Api(description = "Requests for user")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    @ApiOperation(value = "Sign up user")
    void signUpUser(@RequestBody User user) {
        userService.signUpUser(user);
    }
}
