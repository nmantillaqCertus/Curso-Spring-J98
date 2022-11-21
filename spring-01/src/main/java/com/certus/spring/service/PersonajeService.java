package com.certus.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.certus.spring.config.MvcConfig;
import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;
import com.certus.spring.models.ResponseFile;
import com.certus.spring.repository.PersonajeDAO;
import com.certus.spring.service.inteface.IFileGeneric;
import com.certus.spring.service.inteface.IPersonajeService;

@Component("servicio1")
public class PersonajeService implements IPersonajeService {
	
	@Autowired
	PersonajeDAO personajeRepository;
	
	@Autowired
	IFileGeneric fileGeneric;
	
	@Autowired
	MvcConfig config;

	@Override
	public Response<Personaje> crearPersonaje(Personaje p,  MultipartFile fileRecibido) {		
		
		Response<Personaje> response = new Response<>();		
		try {
			
			if (!fileRecibido.isEmpty()) {
				if (p.getUriImagen() != null) {						
					fileGeneric.eliminarFile(p.getUriImagen());
				}
				
				ResponseFile respuesta = fileGeneric.crearFile(fileRecibido);
				if (respuesta.isEstado()) {
					p.setUriImagen(respuesta.getNombreFile());
				}else {
					response.setEstado(false);
					response.setMensaje("Error al procesar el archivo "+respuesta.getNombreFile());
					response.setMensajeError(respuesta.getMensajeError());	
					return response;
				}				
			}
			
			Personaje personaje = personajeRepository.save(p);			
			response.setEstado(true);
			response.setMensaje("El Personaje "+personaje.getNombres()+" ha sido creado correctamente");
			
		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Error al crear el personajes "+p.getNombres());
			response.setMensajeError(e.getStackTrace().toString());
		}		
		return response;
	}

	
	@Override
	public Response<Personaje> editarPersonaje( Integer ID) {

		Response<Personaje> response = new Response<>();
		
		try {
			Optional<Personaje> p = personajeRepository.findById(ID);
			response.setEstado(true);
			response.setData(p.get());
			
		} catch (Exception e) {
			response.setEstado(false);
			response.setMensajeError(e.getStackTrace().toString());
		}
		
		return response;
	}
	
	
	@Override
	public Response<Personaje> eliminarPersonaje(Integer ID) {
		
		Response<Personaje> response = new Response<>();
		
		try {
			Optional<Personaje> p = personajeRepository.findById(ID);
			
			if (p.get().getUriImagen() != null) {						
				fileGeneric.eliminarFile(p.get().getUriImagen());
			}
			
			personajeRepository.deleteById(ID);
			response.setEstado(true);
			response.setMensaje("El personaje "+p.get().getNombres()+" ha sido eliminado");
			
		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Error al eliminar el personaje");
			response.setMensajeError(e.getStackTrace().toString());
		}
				
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
