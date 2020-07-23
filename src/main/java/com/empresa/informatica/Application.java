package com.empresa.informatica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empresa.informatica.entity.Empresa;

@SpringBootApplication
public class Application {
	static final Logger logger = LogManager.getLogger(Empresa.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
