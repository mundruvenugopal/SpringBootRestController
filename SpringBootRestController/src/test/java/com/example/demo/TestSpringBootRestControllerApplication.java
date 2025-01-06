package com.example.demo;

import org.springframework.boot.SpringApplication;

public class TestSpringBootRestControllerApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringBootRestControllerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
