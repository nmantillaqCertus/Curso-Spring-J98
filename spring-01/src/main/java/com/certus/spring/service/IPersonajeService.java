package com.certus.spring.service;

import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;

public interface IPersonajeService {
	
	public Response<Personaje> crearPersonaje(Personaje p);
	
	public String editarPersonaje();
	
	public Response<Personaje> listarPersonaje();

}
