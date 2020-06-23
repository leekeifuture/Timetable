package com.company.timetable.controller;

import com.company.timetable.dto.education.City;
import com.company.timetable.service.VkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
@Api(description = "Requests for user")
public class UsersController {

    @Autowired
    private VkService vkService;

    @GetMapping("/test")
    @ApiOperation(value = "Test controller")
    void signUpUser() {
        List<City> result = vkService.getCities(3);
        System.out.println(result);
    }
}
