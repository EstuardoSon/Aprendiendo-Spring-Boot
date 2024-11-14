package com.example.HolaSpring.myBeans;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.HolaSpring.Product;
import com.example.HolaSpring.Services.IOrderService;
import com.example.HolaSpring.Services.OrderService;

@Configuration
public class MisPrimerosBeans {

    @Bean
    MiBean crearMiBean() {
		MiBean bean= new MiBean();
		return bean;
	}

	@Bean
	IOrderService instanciarOrderService() {
		boolean esProduccion = false;
		if (esProduccion) {
			return new OrderService();
		} else {
			return new IOrderService(){
				@Override
				public void saveProduct(List<Product> productos) {
					System.out.println("Guardando en base fake...");
				}
			};
		}
	}
}
