package com.ensa.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="services")
public class Service implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idEtudiant", nullable = false)
	@JsonIgnoreProperties("roles")
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "cne")
	private Etudiant etudiant;
	

	@NotNull(message = " Must have a description")
	@Column(length = 255, nullable = false)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service(Long id, Etudiant etudiant, @NotNull(message = " Must have a description") String description) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", etudiant=" + etudiant + ", description=" + description + "]";
	}
	
	
}
