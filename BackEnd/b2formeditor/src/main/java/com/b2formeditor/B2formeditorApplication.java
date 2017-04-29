package com.b2formeditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "models", "repositories" })
public class B2formeditorApplication {

	public static void main(String[] args) {
		SpringApplication.run(B2formeditorApplication.class, args);
	}
}
