package com.certus.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;
import com.certus.spring.repository.PersonajeDAO;

@Component("servicio1")
public class PersonajeService implements IPersonajeService {
	
	@Autowired
	PersonajeDAO personajeRepository;	

	public Response<Personaje> crearPersonaje( Personaje personajeRecibo) {		
		Response<Personaje> response = new Response<>();		
		try {
			Personaje personaje = personajeRepository.save(personajeRecibo);			
			response.setEstado(true);
			response.setMensaje("El Personaje "+personaje.getNombres()+" ha sido creado correctamente");
			
		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Error al crear el personajes "+personajeRecibo.getNombres());
			response.setMensajeError(e.getStackTrace().toString());
		}		
		return response;
	}

	
	
	public Response<Personaje> editarPersonaje() {

		Response<Personaje> response = new Response<>();	
		
		return response;
	}




	@Override
	public Response<Personaje> listarPersonaje() {
		
		Response<Personaje> response = new Response<>();
		
		try {
			
			response.setListData((List<Personaje>) personajeRepository.findAll());
			response.setEstado(true);
			response.setMensaje("Personajes obtenidos correctamente");
			
		} catch (Exception e) {			
			response.setEstado(false);
			response.setMensaje("Error al obtener los personajes");
			response.setMensajeError(e.getStackTrace().toString());
		}
		return response;
	}

}
