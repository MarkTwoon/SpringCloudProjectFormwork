package com.chinasoft.springcloud_1.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.springcloud_1.dao.UserDao;
import com.chinasoft.springcloud_1.service.UserService;

@Service
public class UserServiceImpl  
                            implements UserService{
  @Autowired
  private UserDao  userDao;

@Override
public List<Map<String, Object>> selectCityAll() {
	// TODO Auto-generated method stub
	return userDao.selectCityAll();
}

@Override
public Map<String, Object> headNumber(Map<String, Object> map) {
	// TODO Auto-generated method stub
	return userDao.headNumber(map);
}
	
	
	
	
}
