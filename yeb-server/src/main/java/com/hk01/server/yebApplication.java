package com.hk01.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.hk01.server.mapper")
@EnableSwagger2
public class yebApplication {
    public static void main(String[] args) {
        SpringApplication.run(yebApplication.class,args);
    }
}
