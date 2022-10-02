package kz.iitu.cfaslib;

import kz.iitu.cfaslib.feign.AuthFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:lib-application.yaml"})
@EnableFeignClients(clients = AuthFeign.class)
@Configuration
public class CfasLibApplication {

    public static void main(String[] args) {
        SpringApplication.run(CfasLibApplication.class, args);
    }

}
