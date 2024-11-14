package com.example.HolaSpring.myBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MisPrimerosBeans {

    @Bean
    MiBean crearMiBean() {
		MiBean bean= new MiBean();
		return bean;
	}

}
