package com.cdleaf.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class Accounts {
    private List<Account> accountList;

    public Accounts(){

    }

    public Accounts(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Account> getAccountList() {
        if(accountList == null){
            accountList = new ArrayList<>();
        }
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

}
