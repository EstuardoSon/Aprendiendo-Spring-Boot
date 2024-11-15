package com.example.HolaSpring.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.example.HolaSpring.Product;

public class OrderService implements IOrderService {
	
	@Value("${database.db}")
	private String dbHost;

	private final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	public void saveProduct(List<Product> productos) {
		System.out.println("Guardando en la base de datos... " + dbHost);
		productos.forEach(producto -> logger.info("El nombre del producto es {} precio {}", producto.nombre, producto.precio));
	}
}
