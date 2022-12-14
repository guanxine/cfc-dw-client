package io.github.guanxin.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@EnableDubbo
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
        System.out.println("dubbo service started");
    }
}
