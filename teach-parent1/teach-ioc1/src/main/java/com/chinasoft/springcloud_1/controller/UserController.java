package com.chinasoft.springcloud_1.controller;

import com.chinasoft.springcloud_1.service.UserIocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
@Controller
public class UserController {
    @Autowired
    private UserIocService userService;

    @RequestMapping(value="/selectCityAll")
    /*也可以通过 @ResponseBody注解 改成异步控制器返回json数据*/
   // @ResponseBody
    public String selectCityAll(HttpServletRequest request){
        List<Map<String,Object>> list=userService.selectCityAll();
        request.setAttribute("list",list);
        //return list;
        return "index";
    }
}
