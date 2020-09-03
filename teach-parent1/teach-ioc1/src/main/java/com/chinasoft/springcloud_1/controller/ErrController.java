package com.chinasoft.springcloud_1.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrController  implements ErrorController {
    /*在后端 设置一个项目首页的 访问控制器*/
    @RequestMapping("/")
    public String showIndex(HttpServletRequest request){
        return "index";
    }

    /*首先IOC线程抛出异常  会自动访问error路径*/
    @RequestMapping("/error")
    public String showError(HttpServletRequest request){
        return getErrorPath();
    }

    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return "error";
    }
    @RequestMapping("/jsp/{mark}")
    public String mark(@PathVariable("mark") String mark, HttpServletRequest request){
        if(mark.equals("out")){
            /*如果是注销账户的 页面跳转
             * 就一定要清空 null覆盖替换 session的登录状态记录
             * 然后返回首页*/
            request.getSession().setAttribute("adminMap", null);
            return "index";
        }
        /*在跳转子页面中 查询并传递 路径活值*/
        return  mark;
    }
}
