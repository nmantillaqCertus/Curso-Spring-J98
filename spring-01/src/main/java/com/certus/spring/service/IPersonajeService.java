package com.certus.spring.service;

import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;

public interface IPersonajeService {
	
	public Response<Personaje> crearPersonaje(Personaje p);
	
	public Response<Personaje> editarPersonaje(Integer ID);	
	
	public Response<Personaje> eliminarPersonaje(Integer ID);	
	
	public Response<Personaje> listarPersonaje();

}
