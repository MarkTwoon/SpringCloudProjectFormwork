package com.chinasoft.springcloud_1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
 @EnableEurekaClient   //本服务启动后会自动注册进eureka服务中
@EnableCircuitBreaker //ORM 数据熔断安全机制注解
public class OrmApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrmApplication.class, args);
    }

}
