package com.chinasoft.springcloud_1.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserIocServiceFallbackFactory  implements FallbackFactory<UserIocService> {
    @Override
    public UserIocService create(Throwable throwable) {
        return new UserIocService(){
            @Override
            public List<Map<String, Object>> selectCityAll() {
                Map<String,Object> map=new HashMap<String, Object>();
                map.put("mark", "ORM线程运行异常，远程调用数据传输失败");
                List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
                list.add(map);
                return list;
            }
        };
    }
}
