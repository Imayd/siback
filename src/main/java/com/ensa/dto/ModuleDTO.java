package com.ensa.dto;

public class ModuleDTO {

	private Long semestre;
    private String libelle;
	public Long getSemestre() {
		return semestre;
	}
	public void setSemestre(Long semestre) {
		this.semestre = semestre;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public ModuleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModuleDTO(Long semestre, String libelle) {
		super();
		this.semestre = semestre;
		this.libelle = libelle;
	}
    
}
