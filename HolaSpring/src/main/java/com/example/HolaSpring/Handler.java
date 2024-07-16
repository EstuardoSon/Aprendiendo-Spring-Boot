package com.example.HolaSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// CLASE PARA LA CAPTURA DE ERRORES QUE NO SE DESEAN MOSTRAR AL CLIENTE

@RestControllerAdvice
public class Handler {
	
	private final Logger logger = LoggerFactory.getLogger(Handler.class);

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handlerNullPointer(NullPointerException exception) {
		logger.error(exception.getMessage());
		
		return "Internal error. Contact support.";
	}
}
