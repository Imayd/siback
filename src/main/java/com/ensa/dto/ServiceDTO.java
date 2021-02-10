package com.ensa.dto;

public class ServiceDTO {

	private String description;
	private Long idEtudiant;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public ServiceDTO(String description, Long idEtudiant) {
		super();
		this.description = description;
		this.idEtudiant = idEtudiant;
	}
	public ServiceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
