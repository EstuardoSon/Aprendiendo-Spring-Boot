package com.example.HolaSpring;

import java.util.List;
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

import com.example.HolaSpring.Models.Libro;
import com.example.HolaSpring.Models.Usuario;
import com.example.HolaSpring.Services.IOrderService;
import com.example.HolaSpring.myBeans.MiBean;
import com.example.HolaSpring.myBeans.MiComponent;

@RestController
public class ControladorREST {

	/**
	 * DEPENDENCIA DURA ----- INCORRECTO
	 * private OrderService orderService = new OrderService();
	 **/

	/** DEPENDENCIA DINAMICA **/
	private IOrderService orderService;
	private MiBean miBean;
	private MiComponent miComponent;

	public ControladorREST(IOrderService orderService, MiBean miBean, MiComponent miComponent) {
		this.orderService = orderService;
		this.miBean = miBean;
		this.miComponent = miComponent;
	}

	/*****/

	/**
	 * DEPENDENCIA EN ATRIBUTO
	 * 
	 * @Autowired
	 *            private OrderService orderService;
	 **/

	private final Logger logger = LoggerFactory.getLogger(ControladorREST.class);

	@GetMapping("/hola")
	public String comienzo() {
		return "Hola mundo en Spring";
	}

	@GetMapping("/libro/{id}/editorial/{editorial}")
	public String leerLibro(@PathVariable int id, @PathVariable String editorial) {
		return "Leyendo el libro id: " + id + " Editorial: " + editorial;
	}

	@GetMapping("/libro2/{id}")
	public String leerLibro2(@PathVariable int id, @RequestParam String params) {
		return "Leyendo el libro id: " + id + ", params: " + params;
	}

	/* MAPEO DE OBJETO JSON A MAP 
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
	 * @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason = "Fue movida a otro version") 
	 * Se utliliza para informa al consumidor que la ruta ya no esta en uso
	 */

	@GetMapping("/saludar")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public String miSegundaRutaconStatus() {
		return "Aprendiendo Status con Spring";
	}

	@GetMapping("/animales/{lugar}")
	public ResponseEntity<String> getAnimales(@PathVariable String lugar) {
		if (lugar.equals("granja")) {
			return ResponseEntity.status(HttpStatus.OK).body("caballo, vaca, oveja, gallina");
		} else if (lugar.equals("selva")) {
			return ResponseEntity.status(HttpStatus.OK).body("mono, gorila, puma");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existen animales");
	}

	@GetMapping("/calcular/{numero}")
	public int getCalculo(@PathVariable int numero) {
		throw new NullPointerException("la clave del usuario es fasdfas, error inesperado");
	}

	@GetMapping("/userData")
	public ResponseEntity<String> getUserData() {
		return ResponseEntity.status(HttpStatus.OK)
				.header("Content-type", "application/json")
				.body("{\"nombre\":\"estuardo\"}");
	}

	@GetMapping("/userData/v2")
	public Map<String, Map<String, Object>> getUserDataV2() {
		return Map.of("user", Map.of("nombre", "estuardo", "edad", 25));
	}

	@GetMapping("/userData/v3")
	public Usuario getUserDataV3() {
		return new Usuario("estuardo", 22, "ingenieria");
	}

	@PostMapping("/order")
	public String crearOrden(@RequestBody List<Product> datos) {
		orderService.saveProduct(datos);
		return "";
	}

	@GetMapping("/mibean")
	public String saludarDesdeBean() {
		miBean.saludar();
		return "Completado";
	}

	@GetMapping("/micomponent")
	public String saludarDesdeComponent() {
		miComponent.saludar();
		return "Completado";
	}
}
