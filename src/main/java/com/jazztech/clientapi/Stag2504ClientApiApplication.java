package com.jazztech.clientapi;

import com.jazztech.clientapi.service.clientsservice.CreateClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Stag2504ClientApiApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateClient.class);

    public static void main(String[] args) {
        LOGGER.info("Inicializando aplicação");
        SpringApplication.run(Stag2504ClientApiApplication.class, args);
        LOGGER.info("Aplicação inicializada");
    }
}
