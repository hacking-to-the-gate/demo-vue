package com.summer.springvuedemo.demo.dao;

import com.summer.springvuedemo.demo.entity.Maindata;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MainDataDao {
    public int addRecord(@Param("data")Maindata maindata);
    public Maindata getDataById(@Param("id")Integer id);
    public Maindata getDataByName(@Param("name")String name);
    public int updateData(@Param("data")Maindata maindata);
}
