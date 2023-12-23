package com.example.cozastore22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Cozastore22Application {

	public static void main(String[] args) {
		SpringApplication.run(Cozastore22Application.class, args);
	}

}
