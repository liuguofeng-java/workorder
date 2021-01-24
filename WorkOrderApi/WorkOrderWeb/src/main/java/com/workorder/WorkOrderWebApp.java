package com.workorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.workorder.dao")
public class WorkOrderWebApp {
    public static void main(String[]args){
        SpringApplication.run(WorkOrderWebApp.class,args);
    }
}
