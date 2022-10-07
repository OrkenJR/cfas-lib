package kz.iitu.cfaslib;

import kz.iitu.cfaslib.feign.AuthFeign;
import kz.iitu.cfaslib.feign.UserFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:application.properties"})
@EnableFeignClients(clients = {AuthFeign.class, UserFeign.class})
@Configuration
@EnableDiscoveryClient
public class CfasLibApplication {

    public static void main(String[] args) {
        SpringApplication.run(CfasLibApplication.class, args);
    }

}
