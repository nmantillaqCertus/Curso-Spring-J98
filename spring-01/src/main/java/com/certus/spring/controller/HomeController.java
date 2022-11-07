package com.certus.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;
import com.certus.spring.service.IPersonajeService;

@Controller
@RequestMapping("/app")
public class HomeController {

	@Value("${title.generic}")
	private String titlePage;
	
	@Value("${mensaje}")
	private String mensaje;
		
	@Autowired
	@Qualifier("servicio1")
	private IPersonajeService InterfacePersonaje1; 
	
	@Autowired
	@Qualifier("servicio2")
	private IPersonajeService InterfacePersonaje2; 
	

	@GetMapping({ "/home", "/inicio", "/", "/Home", "/Inicio" })
	public String Home(Model model) {
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98");				
		model.addAttribute("Mensaje", mensaje);
		
		return "Home";

	}
	
	@GetMapping("/listar")
	public String ListarPersonajes(Model model) {
		
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98");
		model.addAttribute("Mensaje", mensaje);
		
		Response<Personaje> rspta = InterfacePersonaje1.listarPersonaje();
		
		model.addAttribute("listita", rspta.getData());
		
		return "lista";
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
	public String creaPersonaje(@Valid Personaje Luffy, BindingResult result, Model model) {
		
		if(result.hasErrors()) {						
			return "Formulario";
		}
		
		Response<Personaje> rspta = InterfacePersonaje1.crearPersonaje(Luffy);
		
		if (rspta.getEstado()) {			
			return "redirect:lista";	
		}else {
			model.addAttribute("mensaje", rspta.getMensaje());
			return "redirect:Error";
		}
		
	}
	

}
