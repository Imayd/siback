package com.ensa.entities;

import java.io.Serializable;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "id")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "cne")
public class Etudiant extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Le chemp CNE est obligatoire !!")
	@NotNull(message = "Le chemp CNE est obligatoire !!")
	private String cne;
	
	//@OneToMany
	//private List<Service> services = new ArrayList<>();
	
	@ManyToOne(targetEntity = Niveau.class)
	@JoinColumn(name = "idNiveau", nullable = false)
	private Niveau niveau;

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public Etudiant(String cne) {
		super();
		this.cne = cne;
	}

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public Etudiant(String name, String username, String email, String password,
	 * Role role) { super(name, username, email, password, role); // TODO
	 * Auto-generated constructor stub }
	 */

	public Etudiant(String name, String username, String email, String password) {
		super(name, username, email, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Etudiant [cne=" + cne + ", niveau=" + niveau + "]";
	}

	/*
	 * public List<Service> getServices() { return services; }
	 * 
	 * public void setServices(List<Service> services) { this.services = services; }
	 */

}
