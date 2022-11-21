package com.certus.spring.service.inteface;

import org.springframework.web.multipart.MultipartFile;

import com.certus.spring.models.ResponseFile;

public interface IFileGeneric {
	
	public ResponseFile crearFile(MultipartFile fileGeneric);
	public ResponseFile eliminarFile(String fileName);

}
