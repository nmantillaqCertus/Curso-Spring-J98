package com.certus.spring.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;

@Component("servicio1")
public class PersonajeService implements IPersonajeService {

	public Response<Personaje> crearPersonaje() {
		
		Response<Personaje> response = new Response<>();	
		
		boolean estadoCreacion = false;
		
		List<Personaje> listita = new ArrayList<>();

		// Instanciando un personaje1 del tipo Personaje
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

		// Agregando un personaje a la lista
		listita.add(personaje1);
		listita.add(personaje2);
		listita.add(personaje3);
		
		//Validación de lista de personajes
		if(listita.size() > 0) {
			estadoCreacion = true;
			response.setEstado(estadoCreacion);
			response.setMensaje("Creado Correctamente");
			response.setData(listita);
		}else {
			response.setEstado(estadoCreacion);
			response.setMensaje("Se produjo un error, contactar con el admistrador del sistema");					
		}
		

		return response;
	}

	
	
	
	public String editarPersonaje() {	
		
		return "Se ha editado un personaje";
	}




	@Override
	public String demoMetodo(Personaje p) {
		
		String respuesta = "Procesando";
		
		if(p != null) {
			respuesta = "Todo OK";
		}
		
		return respuesta;
	}

}
