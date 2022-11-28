package com.certus.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;
import com.certus.spring.models.dto.PersonajeDTO;
import com.certus.spring.service.inteface.IPersonajeService;

@RestController
@RequestMapping("/Api")
public class APIController {
	
	@Autowired
	@Qualifier("servicio1")
	private IPersonajeService InterfacePersonaje1;
	
	@GetMapping("/listar")
	public Response<Personaje> listarPersonajes (){		
		Response<Personaje> rspta = InterfacePersonaje1.listarPersonaje();	
		return rspta;
	}
	
	@PutMapping("/editar/{id}")
	public Response<Personaje> editarPersonaje(@RequestBody PersonajeDTO per, @PathVariable  int id){
		Response<Personaje> rspta = new Response<>();
		
		Response<Personaje> rsptaAux = InterfacePersonaje1.editarPersonaje(id);
		
		if (rsptaAux.getEstado()) { //Si existe o no el personaje			
			per.setIdPersonaje(rsptaAux.getData().getIdPersonaje());			
			rspta = InterfacePersonaje1.crearPersonajeAPI(per);
		}else {
			rspta = rsptaAux;
		}
		
		return rspta;
	}
	
	@PostMapping("/crear")
	public Response<Personaje> crearPersonaje (@RequestBody PersonajeDTO per){
		
		Response<Personaje> rspta = InterfacePersonaje1.crearPersonajeAPI(per);
		return rspta;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public Response<Personaje> eliminarPersonaje (@PathVariable int id){		
		Response<Personaje> rspta = InterfacePersonaje1.eliminarPersonaje(id);		
		return rspta;
	}
	
	

}
