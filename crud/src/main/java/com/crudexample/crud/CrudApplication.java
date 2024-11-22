package com.crudexample.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	private static Logger log = LoggerFactory.getLogger(CrudApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
		log.info("Aplicacion iniciada");
	}

}
