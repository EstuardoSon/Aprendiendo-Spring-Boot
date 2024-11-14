package com.example.HolaSpring.myBeans;

import org.springframework.stereotype.Component;

@Component
public class MiComponent {

    public void saludar() {
        System.out.println("Hola desde MiComponent");
    }
}
