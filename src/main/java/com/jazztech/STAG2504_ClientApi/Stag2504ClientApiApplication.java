package com.jazztech.STAG2504_ClientApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Stag2504ClientApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(Stag2504ClientApiApplication.class, args);
	}
}