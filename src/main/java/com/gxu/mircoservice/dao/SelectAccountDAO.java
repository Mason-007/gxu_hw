package com.gxu.mircoservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SelectAccountDAO {
    @Select("${sql}")
    public List<AccountDTO> showAccount(String sql);   
}

