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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Note implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Etudiant.class)
    @JoinColumn(name = "idEtudiant", nullable = false)
    private Etudiant etudiant;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idElementModule", nullable = false)
    private ElementModule elementModule;
    @NotNull(message = "La note est null !!")
    @Min(value = 0,message = "Le note ne doit pas etre < 0")
    @Column(length = 4,nullable = false)
    private Double noteModule;
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
	public ElementModule getElementModule() {
		return elementModule;
	}
	public void setElementModule(ElementModule elementModule) {
		this.elementModule = elementModule;
	}
	public Double getNoteModule() {
		return noteModule;
	}
	public void setNoteModule(Double noteModule) {
		this.noteModule = noteModule;
	}
	public Note(Long id, Etudiant etudiant, ElementModule elementModule,
			@NotNull(message = "La note est null !!") @Min(value = 0, message = "Le note ne doit pas etre < 0") Double noteModule) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		this.elementModule = elementModule;
		this.noteModule = noteModule;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}
