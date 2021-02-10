package com.ensa.entities;

import java.io.Serializable;
import java.util.List;

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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Semestre implements Serializable {


	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @NotNull(message = "Le nom du semestre est obligatoir !!")
	  @Column(length = 20,nullable = false)
	  private String semestre;


	  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "semestre")
	  private List<Module> lModules;

	  
	  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Niveau.class)
	  @JoinColumn(name = "idNiveau")
	  private Niveau niveau;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSemestre() {
		return semestre;
	}


	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}


	public List<Module> getlModules() {
		return lModules;
	}


	public void setlModules(List<Module> lModules) {
		this.lModules = lModules;
	}


	public Niveau getNiveau() {
		return niveau;
	}


	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}


	public Semestre(Long id, @NotNull(message = "Le nom du semestre est obligatoir !!") String semestre,
			List<Module> lModules, Niveau niveau) {
		super();
		this.id = id;
		this.semestre = semestre;
		this.lModules = lModules;
		this.niveau = niveau;
	}


	public Semestre() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	  
	
}
