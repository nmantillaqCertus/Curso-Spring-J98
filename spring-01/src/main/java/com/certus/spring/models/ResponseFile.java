package com.certus.spring.models;

public class ResponseFile {	
	boolean estado;
	String nombreFile;
	String mensajeError;
	
	
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getNombreFile() {
		return nombreFile;
	}
	public void setNombreFile(String nombreFile) {
		this.nombreFile = nombreFile;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	
}
