package com.chinasoft.springcloud_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages="com.chinasoft.springcloud_1.service")
public class IocApplication {

    public static void main(String[] args) {

        SpringApplication.run(IocApplication.class, args);
    }

}
