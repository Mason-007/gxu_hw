package com.gxu.mircoservice.controllers;

import com.gxu.mircoservice.services.AdderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdderController {
    @Autowired 
    AdderService adderService = null;

    @RequestMapping("/adder")
    public int add(@RequestParam int n){
        int res = adderService.adder(n);
        return res;
    }

}
