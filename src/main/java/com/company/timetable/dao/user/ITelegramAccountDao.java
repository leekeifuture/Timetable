package com.company.timetable.dao.user;

import com.company.timetable.dto.user.TelegramAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITelegramAccountDao extends JpaRepository<TelegramAccount, Integer> {
}

