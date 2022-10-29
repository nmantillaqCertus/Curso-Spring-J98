package com.certus.spring.models;

import java.util.List;

public class Response<E> {	
	private boolean estado;
	private String mensaje;
	private List<E> data;
	
	
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<E> getData() {
		return data;
	}
	public void setData(List<E> data) {
		this.data = data;
	}
}
