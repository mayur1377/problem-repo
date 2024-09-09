package com.example.ClearFood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.ClearFood")
public class ClearFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClearFoodApplication.class, args);
	}

}
