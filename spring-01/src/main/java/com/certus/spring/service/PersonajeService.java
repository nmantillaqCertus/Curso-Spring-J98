package com.certus.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;
import com.certus.spring.repository.IPersonaje;

@Component("servicio1")
public class PersonajeService implements IPersonajeService {
	
	@Autowired
	IPersonaje personajeRepository;	

	public Response<Personaje> crearPersonaje( Personaje personajeRecibo) {		
		Response<Personaje> response = new Response<>();
		
		try {
			Personaje psj = personajeRepository.save(personajeRecibo);
			response.setEstado(true);
			response.setMensaje("Creado Correctamente");
			
		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje(e.getMessage());
		}
		
		return response;
	}

	
	
	public String editarPersonaje() {	
		
		return "Se ha editado un personaje";
	}




	@Override
	public Response<Personaje> listarPersonaje() {
		
		List<Personaje> listita = new ArrayList<>();
		Response<Personaje> response = new Response<>();	

		Personaje personaje1 = new Personaje();
		personaje1.setNombres("Luffy");
		personaje1.setAlias("Luffy Alias");
		personaje1.setTipoFruta("Luffy Tipo Fruta");
		personaje1.setHabilidad("Luffy Hablidad");
		personaje1.setTripulacion("Luffy Trupulacion");
		personaje1.setReconpensa("123456789");
		
		Personaje personaje2 = new Personaje();
		personaje2.setNombres("Luffy 2");
		personaje2.setAlias("Luffy Alias 2");
		personaje2.setTipoFruta("Luffy Tipo Fruta 2");
		personaje2.setHabilidad("Luffy Hablidad 2");
		personaje2.setTripulacion("Luffy Trupulacion 2");
		personaje2.setReconpensa("123456789 2");
		
		Personaje personaje3 = new Personaje();
		personaje3.setNombres("Luffy 3");
		personaje3.setAlias("Luffy Alias 3");
		personaje3.setTipoFruta("Luffy Tipo Fruta 3");
		personaje3.setHabilidad("Luffy Hablidad 3");
		personaje3.setTripulacion("Luffy Trupulacion 3");
		personaje3.setReconpensa("123456789 3");
		
		listita.add(personaje1);
		listita.add(personaje2);
		listita.add(personaje3);
		
		response.setEstado(true);
		response.setMensaje("Creado Correctamente");
		response.setData(listita);	
		
		return response;
	}

}
