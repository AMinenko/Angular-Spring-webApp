package com.anmi.mailclient.core.service.impl;

import com.anmi.mailclient.core.dao.impl.MailDaoImpl;
import com.anmi.mailclient.core.entity.Mail;
import com.anmi.mailclient.core.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    MailDaoImpl mailDao;

    @Override
    @Transactional
    public List<Mail> getAll() {
        return mailDao.getAll();
    }
}
