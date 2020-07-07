package com.company.timetable.service;

import com.company.timetable.dao.user.ITelegramAccountDao;
import com.company.timetable.dto.user.TelegramAccount;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Autowired
    private ITelegramAccountDao iTelegramAccountDao;

    @Value("${telegram.bot.token}")
    private String telegramBotToken;

    public Boolean signUpTelegramAccount(TelegramAccount telegramAccount) {
        if (isTelegramAccountDataRight(telegramAccount)) {
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

        System.out.println(hash.equals(hashParam));
        return hash.equals(hashParam);
    }
}
