package com.anmi.mailclient.core.dao.impl;

import com.anmi.mailclient.core.entity.Mail;
import org.springframework.stereotype.Repository;

@Repository
public class MailDaoImpl extends AbstractBaseDao<Mail> {
    @Override
    protected Class<Mail> getEntityClass() {
        return Mail.class;
    }
}
