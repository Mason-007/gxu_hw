package com.gxu.mircoservice.controllers;

import java.util.*;

import com.gxu.mircoservice.dao.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/newAccount.do")
    public void newAccount(@RequestParam String name,@RequestParam String money) {
        String sql = "insert into accounts(name, money) values(\"" + name + "\"," + money + ");";
        createObj.createAccount(sql);
    }

    @PostMapping("/withdraw.do")
    public void withdraw(@RequestParam String id,@RequestParam String money) {
        String sql = "update accounts set money = money - " + money + " where id = " + id + ";";
        updateObj.setAccount(sql);
    }

    @PostMapping("/deposit.do")
    public void deposit(@RequestParam String id,@RequestParam String money) {
        String sql = "update accounts set money = money + " + money + " where id = " + id + ";";
        updateObj.setAccount(sql);
    }

    @PostMapping("/deleteAccount.do")
    public void deleteAccount(@RequestParam String id) {
        String sql = "DELETE FROM ACCOUNTS WHERE ID = " + id + ";";
        deleteObj.delAccount(sql);
    }    
}
