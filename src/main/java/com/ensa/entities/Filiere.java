package com.ensa.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Filiere implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Column(length = 50, nullable = false)
	private String nomFormation;

	@Column(length = 200, nullable = true)
	private String description;

	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "filiere", targetEntity = Niveau.class, fetch = FetchType.EAGER)
	private Collection<Niveau> niveaus;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomFormation() {
		return nomFormation;
	}


	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Collection<Niveau> getNiveaus() {
		return niveaus;
	}


	public void setNiveaus(Collection<Niveau> niveaus) {
		this.niveaus = niveaus;
	}


	public Filiere(Long id, String nomFormation, String description, Collection<Niveau> niveaus) {
		super();
		this.id = id;
		this.nomFormation = nomFormation;
		this.description = description;
		this.niveaus = niveaus;
	}


	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
