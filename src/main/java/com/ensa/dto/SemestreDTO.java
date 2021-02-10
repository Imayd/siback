package com.ensa.dto;

public class SemestreDTO {

	private Long filiere;
    private Long niveau;
    private String semestre;
	public Long getFiliere() {
		return filiere;
	}
	public void setFiliere(Long filiere) {
		this.filiere = filiere;
	}
	public Long getNiveau() {
		return niveau;
	}
	public void setNiveau(Long niveau) {
		this.niveau = niveau;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public SemestreDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SemestreDTO(Long filiere, Long niveau, String semestre) {
		super();
		this.filiere = filiere;
		this.niveau = niveau;
		this.semestre = semestre;
	}
    
}
