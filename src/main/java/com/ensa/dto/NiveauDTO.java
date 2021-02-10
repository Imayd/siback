package com.ensa.dto;

public class NiveauDTO {

	private String niveau;
	private Long filiere;
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public Long getFiliere() {
		return filiere;
	}
	public void setFiliere(Long filiere) {
		this.filiere = filiere;
	}
	public NiveauDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NiveauDTO(String niveau, Long filiere) {
		super();
		this.niveau = niveau;
		this.filiere = filiere;
	}
	    
}
