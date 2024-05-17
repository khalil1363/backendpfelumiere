package com.supportportal.entity;

import javax.persistence.*;

@Entity
@Table(name = "proposition_formation")
public class PropositionFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment
    private Long idProposition;
    private String module;
    private String type;
    private String categorie ;
    private Integer duree;
    private String description;
    private String proposePar;
    
    private boolean isAccepted;

    
    
	public PropositionFormation() {
		super();
	}

	public PropositionFormation(Long idProposition, String module, String type, String categorie, Integer duree,
			String description, String proposePar, boolean isAccepted) {
		super();
		this.idProposition = idProposition;
		this.module = module;
		this.type = type;
		this.categorie = categorie;
		this.duree = duree;
		this.description = description;
		this.proposePar = proposePar;
		this.isAccepted = isAccepted;
	}

	public Long getIdProposition() {
		return idProposition;
	}

	public void setIdProposition(Long idProposition) {
		this.idProposition = idProposition;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProposePar() {
		return proposePar;
	}

	public void setProposePar(String proposePar) {
		this.proposePar = proposePar;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
    
    
    
  }