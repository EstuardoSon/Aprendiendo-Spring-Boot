package com.example.HolaSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HolaSpringApplication {

	/* Codigo para realizar logs */
	private static Logger logger = LoggerFactory.getLogger(HolaSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HolaSpringApplication.class, args);

		// Tipos de Logs
		logger.debug("Log de Debug");
		logger.info("Log de informacion");
		logger.warn("Log de Warning");
		logger.error("Log de Error");

	}
}
