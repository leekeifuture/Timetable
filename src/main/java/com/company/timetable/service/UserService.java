package com.company.timetable.service;

import com.company.timetable.dao.IUserDao;
import com.company.timetable.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserDao iUserDao;

    public void signUpUser(User user) {
        iUserDao.save(user);
    }
}
