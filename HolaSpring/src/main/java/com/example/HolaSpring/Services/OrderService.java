package com.example.HolaSpring.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.HolaSpring.Product;

@Service
public class OrderService {
	
	private final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	public void saveProduct(List<Product> productos) {
		System.out.println("Guardando en la base de datos...");
		productos.forEach(producto -> logger.info("El nombre del producto es {} precio {}", producto.nombre, producto.precio));
	}
}
