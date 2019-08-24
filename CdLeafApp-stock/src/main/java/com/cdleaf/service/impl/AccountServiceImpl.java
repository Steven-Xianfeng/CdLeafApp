package com.cdleaf.service.impl;

import com.cdleaf.dao.entity.Account;
import com.cdleaf.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public String sayHello() {
        return "Hello SpringBoot, this is a test ................................ ";
    }


    @Override
    public Account getAccountById(long id) {
        return null;
    }

    @Override
    public Account getAccountByName(String userName) {
        return null;
    }

    @Override
    public long getAcccountIdByUUID(String uuid) {
        return 0;
    }
}
