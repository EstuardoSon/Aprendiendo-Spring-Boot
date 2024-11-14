package com.example.HolaSpring.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HolaSpring.Product;

@Service
public interface IOrderService {

    public void saveProduct(List<Product> productos);
}
