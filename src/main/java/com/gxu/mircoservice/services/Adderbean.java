package com.gxu.mircoservice.services;

import org.springframework.stereotype.Service;

@Service
public class Adderbean implements AdderService{
    public int adder(int n){
        int res = 0;
        for(int i = 1; i <= n; i++){
            res = res + i;
        }
        return res;
    }
}
