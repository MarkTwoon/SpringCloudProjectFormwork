package com.chinasoft.springcloud_1.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient(value="Teach-orm1", fallbackFactory=UserIocServiceFallbackFactory.class)
public interface UserIocService {
    @RequestMapping(value="/selectCityAll")
    public List<Map<String,Object>> selectCityAll();

}
