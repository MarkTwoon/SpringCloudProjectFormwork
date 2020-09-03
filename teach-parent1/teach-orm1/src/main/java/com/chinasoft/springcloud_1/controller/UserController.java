package com.chinasoft.springcloud_1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chinasoft.springcloud_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/*注意 ORM的controller层  数据传递
 * 统一配置异步接口 返回json数据
 * 注解引入异步控制层*/
@RestController
@RequestMapping(value="/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController<UserService> {
	@Autowired
	 private com.chinasoft.springcloud_1.service.UserService userService;
	
	@RequestMapping(value="/selectCityAll")
	@HystrixCommand(fallbackMethod="hystrixSelectCityAll") //一旦服务调用失败，就调用hystrixSelectCityAll方法
	public List<Map<String,Object>>  selectCityAll(){
	 /*注意 ORM中的controller层控制器方法 均为异步交互 直接返回json数据
	  * 因为ORM控制器 对外提供了一个数据传输的访问action
	  * 对内 内部调用service层 用于执行SQL指令执行结果
	  *  获取select查询结果集  或DML操作的返回布尔值 */
		 List<Map<String,Object>>  list= userService.selectCityAll();
		 /*若查询结果无数据  则抛出熔断异常 转而跳出当前方法体 
		  * 交由熔断方法 进行数据异常捕获处理*/
		if(list.size()==0){
			throw new  RuntimeException();
		}
		return list;
	}

	public  List<Map<String,Object>>  hystrixSelectCityAll(){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("mark", "查询结果为空，不存在指定数据");
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		list.add(map);
		return list;
	}
	
	@RequestMapping(value="/headNumber")
	public Map<String,Object>  headNumber(@RequestBody Map<String,Object> map){
	  return  userService.headNumber(map);	
	}
	
}
