package com.certus.spring.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.certus.spring.config.MvcConfig;
import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;
import com.certus.spring.repository.PersonajeDAO;

@Component("servicio1")
public class PersonajeService implements IPersonajeService {
	
	@Autowired
	PersonajeDAO personajeRepository;
	
	@Autowired
	MvcConfig config;

	@Override
	public Response<Personaje> crearPersonaje(Personaje p,  MultipartFile fileRecibido) {		
		
		Response<Personaje> response = new Response<>();		
		try {
			
			if (!fileRecibido.isEmpty()) {
				try {
					
					if (p.getUriImagen() != null) {
						
						Path enlaceGuardado = Paths.get(config.pathImage()+"\\"+p.getUriImagen());
						File fileEliminar = enlaceGuardado.toFile();
						
						if (fileEliminar.exists()) {
							fileEliminar.delete();
						}
					}
					
					String NewExtention = StringUtils.getFilenameExtension(fileRecibido.getOriginalFilename());
					String newName = UUID.randomUUID().toString() + "." + NewExtention;
					
					
					byte [] bytesFile = fileRecibido.getBytes();
					Path enlaceAGuardar = Paths.get(config.pathImage()+"//"+newName);
					Files.write(enlaceAGuardar, bytesFile);
					
					p.setUriImagen(newName);
					
				} catch (IOException e) {
					response.setEstado(false);
					response.setMensaje("Error al crear el personajes "+p.getNombres());
					response.setMensajeError(e.getStackTrace().toString());	
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
			
			
			Path rutaElimarFile = Paths.get(config.pathImage()+"/"+p.get().getUriImagen());			
			File fileEliminar = rutaElimarFile.toFile();
			if (fileEliminar.exists()) {
				fileEliminar.delete();
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
