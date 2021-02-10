package com.ensa.dto;

public class CoursDTO {

	private String libelle;
	private String motCle;
	private String elementModule;
	
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public String getElementModule() {
		return elementModule;
	}
	public void setElementModule(String elementModule) {
		this.elementModule = elementModule;
	}
	public CoursDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CoursDTO(String libelle, String motCle, String elementModule) {
		super();
		this.libelle = libelle;
		this.motCle = motCle;
		this.elementModule = elementModule;
	}
	@Override
	public String toString() {
		return "CoursDTO [libelle=" + libelle + ", motCle=" + motCle + ", elementModule=" + elementModule + "]";
	}
	
	 
	
}
