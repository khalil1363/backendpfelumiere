package com.supportportal.entity;

import javax.persistence.*;

@Entity
@Table(name = "formation") // Adjust table name if needed
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment
    private Long idFormation;
    private String module;
    private String categorie;
    private String type;
    private Integer duree;
	public Long getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public Formation(Long idFormation, String module, String categorie, String type, Integer duree) {
		super();
		this.idFormation = idFormation;
		this.module = module;
		this.categorie = categorie;
		this.type = type;
		this.duree = duree;
	}
	public Formation() {
		super();
	
	}

    
}