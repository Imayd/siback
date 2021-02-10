package com.ensa.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Absence implements Serializable {

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

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Module.class)
    @JoinColumn(name = "idModule", nullable = false)
    private Module module;

    @NotNull(message = "Le nombre d'absence est obligatoire!!")
    @Column(length = 5, nullable = false)
    private Long nbrSeanceAbs = 0L;

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

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Long getNbrSeanceAbs() {
		return nbrSeanceAbs;
	}

	public void setNbrSeanceAbs(Long nbrSeanceAbs) {
		this.nbrSeanceAbs = nbrSeanceAbs;
	}

	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Absence(Long id, Etudiant etudiant, Module module,
			@NotNull(message = "Le nombre d'absence est obligatoire!!") Long nbrSeanceAbs) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		this.module = module;
		this.nbrSeanceAbs = nbrSeanceAbs;
	}
    
    
}
