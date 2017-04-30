package com.b2formeditor;

/**
 * Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan({ "com.b2formeditor.models",
        "com.b2formeditor.repositories",
        "com.b2formeditor.services",
        "com.b2formeditor.controllers" })
public class B2formeditorApplication {

	public static void main(String[] args) {
		SpringApplication.run(B2formeditorApplication.class, args);
	}
}
