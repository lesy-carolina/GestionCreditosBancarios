package org.nttdata.com.servicioprestamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServicioPrestamosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioPrestamosApplication.class, args);
    }

}
