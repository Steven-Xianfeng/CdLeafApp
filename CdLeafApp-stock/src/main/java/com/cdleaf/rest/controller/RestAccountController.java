package com.cdleaf.rest.controller;

import com.cdleaf.dao.entity.Account;
import com.cdleaf.dao.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/account")
public class RestAccountController {


    @Autowired
    private AccountRepository accountRepository;

    @GetMapping(path="/all", produces = "application/json")
    public List<Account> getEmployees()
    {
        return accountRepository.findAll();
    }



}
