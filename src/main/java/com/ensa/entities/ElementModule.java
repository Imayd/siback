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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "libelle")
public class ElementModule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String libelle;

    //@JsonIgnore
    @JsonBackReference
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "libelle")
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Module.class)
    @JoinColumn(name = "idModule", nullable = false)
    private Module module;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Cours.class, mappedBy = "elementModule", fetch = FetchType.EAGER)
    private Collection<Cours> cours;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Enseignant.class)
    @JoinColumn(name = "idProf", nullable = false)
    private Enseignant prof;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Collection<Cours> getCours() {
		return cours;
	}

	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}

	public Enseignant getProf() {
		return prof;
	}

	public void setProf(Enseignant prof) {
		this.prof = prof;
	}

	public ElementModule(Long id, String libelle, Module module, Collection<Cours> cours, Enseignant prof) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.module = module;
		this.cours = cours;
		this.prof = prof;
	}

	public ElementModule() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
