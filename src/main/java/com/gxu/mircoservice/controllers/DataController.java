package com.gxu.mircoservice.controllers;

import java.util.*;

import com.gxu.mircoservice.dao.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Io;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    @Autowired
    private SelectAccountDAO checkObj;
    @Autowired
    private CreateAccountDAO createObj;
    @Autowired
    private UpdateAccountDAO updateObj;
    @Autowired
    private DeleteAccountDAO deleteObj;

    @RequestMapping("/showAllAccounts.do")
    public List<AccountDTO> showALLAccounts() {
        String sql = "select id as accountId, name as accountName, money from accounts;";
        List<AccountDTO> data = checkObj.showAccount(sql);
        return data;
    }
    
    @RequestMapping("/checkSavings.do")
    public List<AccountDTO> checkSavings(String id) {
        String sql = "select id as accountId, name as accountName, money from accounts where id = " + id + ";";
        List<AccountDTO> data = checkObj.showAccount(sql);
        return data;
    }

    @RequestMapping("/newAccount.do")
    public void newAccount(String name, String money) {
        String sql = "insert into accounts(name, money) values(\"" + name + "\"," + money + ");";
        createObj.createAccount(sql);
    }

    @RequestMapping("/withdraw.do")
    public void withdraw(String id, String money) {
        String sql = "update accounts set money = money - " + money + " where id = " + id + ";";
        updateObj.setAccount(sql);
    }

    @RequestMapping("/deposit.do")
    public void deposit(String id, String money) {
        String sql = "update accounts set money = money + " + money + " where id = " + id + ";";
        updateObj.setAccount(sql);
    }

    @RequestMapping("/deleteAccount.do")
    public void deleteAccount(String id) {
        String sql = "DELETE FROM ACCOUNTS WHERE ID = " + id + ";";
        deleteObj.delAccount(sql);
    }    
}
