package com.gxu.mircoservice.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UpdateAccountDAO {
    @Update("${sql}")
    public void setAccount(String sql);
}
