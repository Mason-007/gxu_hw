package com.gxu.mircoservice.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeleteAccountDAO {
    @Delete("${sql}")
    public void delAccount(String sql);
}
