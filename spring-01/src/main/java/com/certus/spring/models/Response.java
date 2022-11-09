package com.certus.spring.models;

import java.util.List;

public class Response<E> {	
	private boolean estado;
	private String mensaje;
	private String mensajeError; 
	private E data;
	private List<E> ListData;
	
	
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public List<E> getListData() {
		return ListData;
	}
	public void setListData(List<E> listData) {
		ListData = listData;
	}
	
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
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
}
