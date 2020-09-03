package com.chinasoft.springcloud_1.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserDao {
public List<Map<String,Object>>  selectCityAll();
public  Map<String,Object>   headNumber(Map<String, Object> map);
}
