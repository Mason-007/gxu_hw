package com.gxu.mircoservice.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CreateAccountDAO {
    @Insert("${sql}")
    public void createAccount(String sql);
}
