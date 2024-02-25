package com.slavbx.monserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.ExceptionHandler;

@SpringBootApplication
public class MonitoringServiceSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoringServiceSpringBootApplication.class, args);
	}

}
