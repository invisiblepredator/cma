package com.gpw.cma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(scanBasePackages = "com.gpw.cma")
@EnableSpringDataWebSupport
@EnableSwagger2
public class CMA {
    public static void main(String[] args) {
        SpringApplication.run(CMA.class, args);
    }
}