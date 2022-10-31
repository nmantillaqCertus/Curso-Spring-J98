package com.certus.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.certus.spring.models.Personaje;
import com.certus.spring.service.IPersonajeService;

@Controller
@RequestMapping("/app")
public class HomeController {

	@Value("${title.generic}")
	private String titlePage;
		
	@Autowired
	@Qualifier("servicio1")
	private IPersonajeService InterfacePersonaje1; 
	
	@Autowired
	@Qualifier("servicio2")
	private IPersonajeService InterfacePersonaje2; 
	

	@GetMapping({ "/home", "/inicio", "/", "/Home", "/Inicio" })
	public String Home(Model model) {
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98 - Demo listado");
		
		//List<Personaje>  listasUnidas =  new ArrayList<>();
		
		if (InterfacePersonaje1.crearPersonaje().getEstado()) {			
			model.addAttribute("listita", InterfacePersonaje1.crearPersonaje().getData());
		}
		
		
		/*listasUnidas.addAll(InterfacePersonaje1.crearPersonaje().getData());
		listasUnidas.addAll(InterfacePersonaje2.crearPersonaje().getData());
		
		model.addAttribute("listita", listasUnidas);*/
		
		model.addAttribute("Estado", InterfacePersonaje1.crearPersonaje().getMensaje());
		
		Personaje personaje =  new Personaje();
		
		String respuesta = InterfacePersonaje2.demoMetodo(personaje);
		
		model.addAttribute("respuesta", respuesta);
		
		return "Home";

	}
	
	@GetMapping("/crear")
	public String Formulario(Model model) {
		Personaje personaje =  new Personaje();
		
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98 - Crear Personaje");		
		model.addAttribute("personaje", personaje);
		
		return "Formulario";		
	}
	
	@PostMapping("/form")
	public String creaPersonaje( @RequestParam String nombres, 
								 @RequestParam String alias,
								 @RequestParam String tipoFruta,
								 @RequestParam String habilidad,
								 @RequestParam String tripulacion,
								 @RequestParam String reconpensa,
								 Model model) {
		
		Personaje personaje =  new Personaje();				
		personaje.setNombres(nombres);
		personaje.setAlias(alias);
		personaje.setTipoFruta(tipoFruta);
		personaje.setHabilidad(habilidad);
		personaje.setTripulacion(tripulacion);
		personaje.setReconpensa(reconpensa);
		
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98 - Personaje Creado");		
		model.addAttribute("personaje", personaje);
		
		return "Formulario";		
	}
	

}
