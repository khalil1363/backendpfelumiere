package com.supportportal.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "recrutement") 
public class Recrutement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idRecrutement;

    private String departement;
    
    private String recruteur;
    
    private String nomCondidat;
    
    private String commentaire;
    
    private Date  dateDemandeRec; 
    
    // enum
    private String emploiDemandeType;
    
    private String sourceType;
    
    private String selectionPhase;
    
    private String desisionType;
    
    private String vueGestionaire;
    
    private String vueDecideur;
    
    private String vueRh;
    
    
    // Associations One-to-One unidirectionnelle
    @OneToOne
    @JoinColumn(name = "idCandidat")
    private Candidat candidat; 

    @OneToOne
    @JoinColumn(name = "idOffreEmploi")
    @JsonIgnoreProperties("candidatures")
    private OffreEmploi offreEmploi;   
     
    
	public Recrutement() {
		super();
	}


	public Long getIdRecrutement() {
		return idRecrutement;
	}


	public void setIdRecrutement(Long idRecrutement) {
		this.idRecrutement = idRecrutement;
	}


	public String getDepartement() {
		return departement;
	}


	public void setDepartement(String departement) {
		this.departement = departement;
	}


	public String getRecruteur() {
		return recruteur;
	}


	public void setRecruteur(String recruteur) {
		this.recruteur = recruteur;
	}


	public String getNomCondidat() {
		return nomCondidat;
	}


	public void setNomCondidat(String nomCondidat) {
		this.nomCondidat = nomCondidat;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public Date getDateDemandeRec() {
		return dateDemandeRec;
	}


	public void setDateDemandeRec(Date dateDemandeRec) {
		this.dateDemandeRec = dateDemandeRec;
	}


	public String getEmploiDemandeType() {
		return emploiDemandeType;
	}


	public void setEmploiDemandeType(String emploiDemandeType) {
		this.emploiDemandeType = emploiDemandeType;
	}


	public String getSourceType() {
		return sourceType;
	}


	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}


	public String getSelectionPhase() {
		return selectionPhase;
	}


	public void setSelectionPhase(String selectionPhase) {
		this.selectionPhase = selectionPhase;
	}


	public String getDesisionType() {
		return desisionType;
	}


	public void setDesisionType(String desisionType) {
		this.desisionType = desisionType;
	}


	public String getVueGestionaire() {
		return vueGestionaire;
	}


	public void setVueGestionaire(String vueGestionaire) {
		this.vueGestionaire = vueGestionaire;
	}


	public String getVueDecideur() {
		return vueDecideur;
	}


	public void setVueDecideur(String vueDecideur) {
		this.vueDecideur = vueDecideur;
	}


	public String getVueRh() {
		return vueRh;
	}


	public void setVueRh(String vueRh) {
		this.vueRh = vueRh;
	}


	public Candidat getCandidat() {
		return candidat;
	}


	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}


	public OffreEmploi getOffreEmploi() {
		return offreEmploi;
	}


	public void setOffreEmploi(OffreEmploi offreEmploi) {
		this.offreEmploi = offreEmploi;
	}
	
	
 
}