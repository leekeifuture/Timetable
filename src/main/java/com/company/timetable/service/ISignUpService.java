package com.company.timetable.service;

import com.company.timetable.dto.user.TelegramAccount;
import com.company.timetable.dto.user.User;

public interface ISignUpService {

    User signUpUser(User user);

    Boolean isTelegramAccountDataRight(TelegramAccount telegramAccount);

    Boolean signUpTelegramAccount(TelegramAccount telegramAccount);
}
