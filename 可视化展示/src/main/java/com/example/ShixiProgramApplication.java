package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ShixiProgramApplication {

    public static void main(String[] args) {
        System.out.println("启动。。。。");
        SpringApplication.run(ShixiProgramApplication.class, args);
        System.out.println("启动完成。。。。");
    }

    @RequestMapping("/index")
    public String index(){
        return "index";  //跳转到index.html页面
    }

}
