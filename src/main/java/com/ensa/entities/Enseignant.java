package com.ensa.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Enseignant extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cin;

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Enseignant(String cin) {
		super();
		this.cin = cin;
	}

	public Enseignant(String name, String username, String email, String password) {
		super(name,username,email,password);
		// TODO Auto-generated constructor stub
	}
	
	public Enseignant() {
		super();
		
	}
	
	 public Enseignant(String cin, Collection<ElementModule> lElementModules) {
		super();
		this.cin = cin;
		this.lElementModules = lElementModules;
	}



	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prof")
	  private Collection<ElementModule> lElementModules;
	 
	
}
