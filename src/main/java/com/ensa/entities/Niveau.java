package com.ensa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Niveau implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(length = 50, nullable = false)
    private String niveau;

    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "niveau", fetch = FetchType.EAGER)
    private Collection<Semestre> semestres = new HashSet<>();


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Filiere.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idFiliere", nullable = false)
    private Filiere filiere;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "niveau")
    private Collection<Etudiant> etudiants = new HashSet<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNiveau() {
		return niveau;
	}


	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}


	public Collection<Semestre> getSemestres() {
		return semestres;
	}


	public void setSemestres(Collection<Semestre> semestres) {
		this.semestres = semestres;
	}


	public Filiere getFiliere() {
		return filiere;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}


	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}


	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}


	public Niveau() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Niveau(Long id, String niveau, Collection<Semestre> semestres, Filiere filiere,
			Collection<Etudiant> etudiants) {
		super();
		this.id = id;
		this.niveau = niveau;
		this.semestres = semestres;
		this.filiere = filiere;
		this.etudiants = etudiants;
	}
    
    
}
