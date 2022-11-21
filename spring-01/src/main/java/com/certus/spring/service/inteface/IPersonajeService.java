package com.certus.spring.service.inteface;

import org.springframework.web.multipart.MultipartFile;

import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;

public interface IPersonajeService {
	
	public Response<Personaje> crearPersonaje(Personaje p,  MultipartFile fileRecibido);
	
	public Response<Personaje> editarPersonaje(Integer ID);	
	
	public Response<Personaje> eliminarPersonaje(Integer ID);	
	
	public Response<Personaje> listarPersonaje();

}
