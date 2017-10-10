package com.dongjun.springbootswagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Springbootswagger2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootswagger2Application.class, args);
	}
}
