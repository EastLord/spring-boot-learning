package com.druid.springbootdruid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringbootdruidApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdruidApplication.class, args);
	}
}
