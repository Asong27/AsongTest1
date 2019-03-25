package com.idea.spring.test.springtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//可以使用servlet listener filter
@ServletComponentScan
//指定mapper的位置
@MapperScan("com.idea.spring.test.springtest.mapper")
//声明这是整个SpringBoot项目的启动Application
@SpringBootApplication
//开启事务管理
@EnableTransactionManagement
public class SpringTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
    }

}
