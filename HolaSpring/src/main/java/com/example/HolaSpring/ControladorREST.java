package com.example.HolaSpring;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.HolaSpring.models.Libro;

@RestController
public class ControladorREST {
	
	private final Logger logger = LoggerFactory.getLogger(ControladorREST.class);
    
    @GetMapping("/hola")
    public String comienzo(){
        return "Hola mundo en Spring";
    }
    
    @GetMapping("/libro/{id}/editorial/{editorial}")
    public String leerLibro(@PathVariable int id, @PathVariable String editorial){
        return "Leyendo el libro id: " + id + " Editorial: " + editorial;
    }
    
    @GetMapping("/libro2/{id}")
    public String leerLibro2(@PathVariable int id, @RequestParam String params){
        return "Leyendo el libro id: " + id + ", params: " + params;
    }
    
    /*
    @PostMapping("/libro")
    public String guardarLibro(@RequestBody Map<String, Object> libro) {
    	libro.keySet().forEach(llave -> {
    		logger.info("llave {} valor {}", llave, libro.get(llave));
    	});
    	return "Libro guardado";
    }
    */
    
    @PostMapping("/libro")
    public String guardarLibro(@RequestBody Libro libro) {
    	logger.info(libro.toString());
    	return "Libro guardado";
    }
    
    /*
      @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason = "Fue movida a otro version")
      * Se utliliza para informa al consumidor que la ruta ya no esta en uso
     */
    
    @GetMapping("/saludar")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String miSegundaRutaconStatus() {
    	return "Aprendiendo Status con Spring";
    }
    
    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> getAnimales(@PathVariable String lugar){
    	if(lugar.equals("granja")) {
    		return ResponseEntity.status(HttpStatus.OK).body("caballo, vaca, oveja, gallina");
    	} else if(lugar.equals("selva")){
    		return ResponseEntity.status(HttpStatus.OK).body("mono, gorila, puma");
    	}
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existen animales");
    }
    
    @GetMapping("/calcular/{numero}")
    public int getCalculo(@PathVariable int numero) {
    	throw new NullPointerException("la clave del usuario es fasdfas, error inesperado");
    }
}
