package com.b2formeditor;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "models", "repositories", "services", "controllers" })
public class B2formeditorApplication {

	public static void main(String[] args) {
		SpringApplication.run(B2formeditorApplication.class, args);
	}
}
