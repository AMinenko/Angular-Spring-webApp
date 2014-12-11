package com.anmi.mailclient.core.dao.impl;

import com.anmi.mailclient.core.dao.AccountDao;
import com.anmi.mailclient.core.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl extends AbstractBaseDao<Account> implements AccountDao<Account> {

    @Override
    protected Class<Account> getEntityClass() {
        return Account.class;
    }
}
