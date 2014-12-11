package com.anmi.mailclient.core.service;

import com.anmi.mailclient.core.entity.Mail;

import java.util.List;


public interface MailService {
    List<Mail> getAll();
}
