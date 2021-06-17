package com.summer.springvuedemo.demo.dao;

import com.summer.springvuedemo.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDao {
    public User getUserByMessage(@Param("username") String username, @Param("password") String password);
}
