package com.cdleaf.service;

import com.cdleaf.dao.entity.Account;

public interface AccountService {
    String sayHello();

    Account getAccountById(long id);

    Account getAccountByName(String userName);

    long getAcccountIdByUUID(String uuid);


}
