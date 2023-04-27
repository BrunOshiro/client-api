package com.jazztech.STAG2504_ClientApi;

import com.jazztech.STAG2504_ClientApi.infrastructure.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppConfig.class)
@SpringBootApplication
public class Stag2504ClientApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(Stag2504ClientApiApplication.class, args);
	}
}