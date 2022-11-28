package com.certus.spring.service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.certus.spring.helper.responseFileGeneric;
import com.certus.spring.service.inteface.IHelper;

@Service
public class HelperFileService implements IHelper {

	@Override
	public responseFileGeneric procesarFile(String fileBase64) {
		responseFileGeneric rfg = new responseFileGeneric();		
		byte [] fileContent = null;
		
		if (!fileBase64.isEmpty()) {
			try {
				fileContent = Base64.getDecoder().decode( new String(fileBase64).getBytes("UTF-8"));
				rfg.setFileBytes(fileContent);
				rfg.setEstado(true);
				rfg.setMensaje("Archivo procesado correctamente");				
			} catch (UnsupportedEncodingException e) {
				rfg.setEstado(false);
				rfg.setMensaje("Se produjo un erro al procesar el archivo");
			}
		}
		
		return rfg;
	}

}
