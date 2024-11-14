package com.example.HolaSpring.Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public record Usuario(String nombre, @JsonIgnore int edad, @JsonProperty("facultad") String carrera) {

	/* Reemplaza toda la respuesta del json por la informacion en el return
		@JsonValue
		public String info() {
			return "Nombre: " + nombre;
		}
	*/
	
	@JsonGetter("informacion")
	public String info() {
		return "El nombre de usuario " + nombre;
	}
}
