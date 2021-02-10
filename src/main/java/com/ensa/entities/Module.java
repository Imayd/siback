package com.ensa.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "libelle")
public class Module implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @NotNull(message = "Le nom du module est obligatoire !!")
	  @Size(max = 50, min = 3, message = "La longeur du  nom de module est entre 3 char et 50 char")
	  @Column(length = 50, nullable = false)
	  private String libelle;

	  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	  @ManyToOne(cascade = CascadeType.ALL, targetEntity = Semestre.class)
	  @JoinColumn(name = "idSemestre", nullable = false)
	  private Semestre semestre;

	/*  @ManyToOne(cascade = CascadeType.ALL, targetEntity = Filiere.class)
	  @JoinColumn(name = "idFiliere",nullable = false)
	  private Filiere filiere;*/

	  //@JsonIgnore
	  //@JsonIgnoreProperties("module")
	  //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	  //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	  @JsonBackReference
	  @OneToMany(cascade = CascadeType.ALL, targetEntity = ElementModule.class, mappedBy = "module", fetch = FetchType.LAZY)
	  private List<ElementModule> elementModules;

	  @OneToMany(targetEntity = Absence.class, mappedBy = "module")
	  private Collection<Absence> absences;

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

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public List<ElementModule> getElementModules() {
		return elementModules;
	}

	
	public void setElementModules(List<ElementModule> elementModules) {
		this.elementModules = elementModules;
	}

	public Collection<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(Collection<Absence> absences) {
		this.absences = absences;
	}

	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Module(Long id,
			@NotNull(message = "Le nom du module est obligatoire !!") @Size(max = 50, min = 3, message = "La longeur du  nom de module est entre 3 char et 50 char") String libelle,
			Semestre semestre, List<ElementModule> elementModules, Collection<Absence> absences) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.semestre = semestre;
		this.elementModules = elementModules;
		this.absences = absences;
	}
	  
	  
	  
}
