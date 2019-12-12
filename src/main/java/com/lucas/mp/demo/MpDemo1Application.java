package com.lucas.mp.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuxu
 */
@SpringBootApplication
@MapperScan("com.lucas.mp.demo.dao")
public class MpDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(MpDemo1Application.class, args);
    }        // 设置模块名称 pc.setModuleName("sys");


}
