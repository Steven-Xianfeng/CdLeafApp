package com.cdleaf.controller;

import com.cdleaf.dao.entity.Account;
import com.cdleaf.dao.entity.Accounts;
import com.cdleaf.dao.repository.AccountRepository;
import com.cdleaf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/accounts")
public class HelloController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;




    @GetMapping(path="/", produces = "application/json")
    public Accounts getAccounts(){

//        model.addAttribute("hello", "World");

//        return accountService.sayHello();

//        return "hello";

//        Account account =  accountRepository.findAccountById(1L);

        List<Account> list = accountRepository.findAll();
        System.out.println(list);

        return new Accounts(list);
    }

//    @GetMapping("/show")
//    @ResponseBody
    public Account show(String name){

        return accountRepository.findAccountByUserName(name);
    }

}
