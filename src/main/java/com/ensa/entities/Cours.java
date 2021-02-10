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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Cours implements Serializable {

	@Override
	public String toString() {
		return "Cours [id=" + id + ", label=" + label + ", mot_clé=" + mot_clé + ", elementModule=" + elementModule
				+ "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "must have a label !!!")
	@NotBlank(message = "must have a label !!!")
	@Column(length = 30, nullable = false)
	private String label;
	
	@Column
	private String mot_clé;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = ElementModule.class)
	@JoinColumn(name = "idElement", nullable = false)
	//@JsonIgnore
	private ElementModule elementModule;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMot_clé() {
		return mot_clé;
	}

	public void setMot_clé(String mot_clé) {
		this.mot_clé = mot_clé;
	}

	public ElementModule getElementModule() {
		return elementModule;
	}

	public void setElementModule(ElementModule elementModule) {
		this.elementModule = elementModule;
	}

	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cours(Long id,
			@NotNull(message = "must have a label !!!") @NotBlank(message = "must have a label !!!") String label,
			String mot_clé, ElementModule elementModule) {
		super();
		this.id = id;
		this.label = label;
		this.mot_clé = mot_clé;
		this.elementModule = elementModule;
	}
	
	
	
}
