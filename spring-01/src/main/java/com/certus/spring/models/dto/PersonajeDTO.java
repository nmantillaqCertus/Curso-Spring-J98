package com.certus.spring.models.dto;


public class PersonajeDTO {
	
	private int idPersonaje;
	private String nombres;
	private String alias;	
	private String tipoFruta;
	private String habilidad;
	private String tripulacion;
	private String reconpensa;
	private String uriImagen;
	private String nombreFileExtension;
	private String fileBase64;
	
	public String getNombreFileExtension() {
		return nombreFileExtension;
	}
	public void setNombreFileExtension(String nombreFileExtension) {
		this.nombreFileExtension = nombreFileExtension;
	}
	public int getIdPersonaje() {
		return idPersonaje;
	}
	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getTipoFruta() {
		return tipoFruta;
	}
	public void setTipoFruta(String tipoFruta) {
		this.tipoFruta = tipoFruta;
	}
	public String getHabilidad() {
		return habilidad;
	}
	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}
	public String getTripulacion() {
		return tripulacion;
	}
	public void setTripulacion(String tripulacion) {
		this.tripulacion = tripulacion;
	}
	public String getReconpensa() {
		return reconpensa;
	}
	public void setReconpensa(String reconpensa) {
		this.reconpensa = reconpensa;
	}
	public String getUriImagen() {
		return uriImagen;
	}
	public void setUriImagen(String uriImagen) {
		this.uriImagen = uriImagen;
	}
	public String getFileBase64() {
		return fileBase64;
	}
	public void setFileBase64(String fileBase64) {
		this.fileBase64 = fileBase64;
	}
	
	

}
