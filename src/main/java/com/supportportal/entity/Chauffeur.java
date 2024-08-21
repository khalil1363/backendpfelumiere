package com.supportportal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Chauffeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String mat;
    private String ste;
    private String nom;
    private String prenom;
    private String site;
    private String reference;
    private String signature;
    private String remarque;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	public String getSte() {
		return ste;
	}
	public void setSte(String ste) {
		this.ste = ste;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public Chauffeur(Long id, Date date, String mat, String ste, String nom, String prenom, String site,
			String reference, String signature, String remarque) {
		super();
		this.id = id;
		this.date = date;
		this.mat = mat;
		this.ste = ste;
		this.nom = nom;
		this.prenom = prenom;
		this.site = site;
		this.reference = reference;
		this.signature = signature;
		this.remarque = remarque;
	}
	public Chauffeur() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
    
    
    
    
}