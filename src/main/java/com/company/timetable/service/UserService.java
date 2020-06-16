package com.company.timetable.service;

import com.company.timetable.dao.IUserDao;
import com.company.timetable.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserDao iUserDao;

    public List<User> getAll() {
        return iUserDao.findAll();
    }
}
