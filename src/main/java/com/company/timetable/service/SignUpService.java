package com.company.timetable.service;

import com.company.timetable.dao.IUserDao;
import com.company.timetable.dao.user.ITelegramAccountDao;
import com.company.timetable.dto.user.TelegramAccount;
import com.company.timetable.dto.user.User;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SignUpService {

    @Autowired
    private ITelegramAccountDao iTelegramAccountDao;
    @Autowired
    private IUserDao iUserDao;

    @Value("${telegram.bot.token}")
    private String telegramBotToken;

    public User signUpUser(User user) {
        return iUserDao.save(user);
    }

    public Boolean signUpTelegramAccount(TelegramAccount telegramAccount) {
        if (isTelegramAccountDataRight(telegramAccount)) {
            // casting authDate to full unix time
            telegramAccount.setAuthDate(new Date(telegramAccount.getAuthDate().getTime() * 1000));
            iTelegramAccountDao.save(telegramAccount);
            return true;
        }
        return false;
    }

    private Boolean isTelegramAccountDataRight(TelegramAccount telegramAccount) {
        byte[] message = telegramAccount.toString().getBytes();
        byte[] tokenHash = DigestUtils.sha256(telegramBotToken);

        String hashParam = telegramAccount.getHash();
        String hash = HmacUtils.hmacSha256Hex(tokenHash, message);

        return hash.equals(hashParam);
    }
}
