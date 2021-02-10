package com.ensa.dto;

public class ElementModuleDTO {

	private Long filiere;
    private Long Niveau;
    private Long Semestre;
    private Long Module;
    private String element_module;
    private Long prof;
    
	public Long getFiliere() {
		return filiere;
	}
	public void setFiliere(Long filiere) {
		this.filiere = filiere;
	}
	public Long getNiveau() {
		return Niveau;
	}
	public void setNiveau(Long niveau) {
		Niveau = niveau;
	}
	public Long getSemestre() {
		return Semestre;
	}
	public void setSemestre(Long semestre) {
		Semestre = semestre;
	}
	public Long getModule() {
		return Module;
	}
	public void setModule(Long module) {
		Module = module;
	}
	public String getElement_module() {
		return element_module;
	}
	public void setElement_module(String element_module) {
		this.element_module = element_module;
	}
	public Long getProf() {
		return prof;
	}
	public void setProf(Long prof) {
		this.prof = prof;
	}
    
}
