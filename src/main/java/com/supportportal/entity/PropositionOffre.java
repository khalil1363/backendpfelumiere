package com.supportportal.entity;

import java.util.*;


import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PropositionOffre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOffreProp;
    
    private String departement;
    private String jobTitle;
    private Double coutEmbauche;
    private String duree;
    private String motifRecretement;
    private boolean isAccepted ;
    
    @Temporal(TemporalType.DATE)
    private Date dateLancement;
   
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateEmbauche;
    
      
    private String recruteur; 
    private String modeRecretement;
    private String statusPropo;
    
        

	public PropositionOffre() {
		super();
	}


	public PropositionOffre(Long idOffreProp, String departement, String jobTitle, Date dateLancement,
			Date dateEmbauche, Double coutEmbauche, String duree, String motifRecretement, String recruteur,
			String modeRecretement, String statusPropo , boolean isAccepted) {
		super();
		this.idOffreProp = idOffreProp;
		this.departement = departement;
		this.jobTitle = jobTitle;
		this.dateLancement = dateLancement;
		this.dateEmbauche = dateEmbauche;
		this.coutEmbauche = coutEmbauche;
		this.duree = duree;
		this.motifRecretement = motifRecretement;
		this.recruteur = recruteur;
		this.modeRecretement = modeRecretement;
		this.statusPropo = statusPropo;
		this.isAccepted=isAccepted;
	}


	public Long getIdOffreProp() {
		return idOffreProp;
	}


	public void setIdOffreProp(Long idOffreProp) {
		this.idOffreProp = idOffreProp;
	}


	public String getDepartement() {
		return departement;
	}


	public void setDepartement(String departement) {
		this.departement = departement;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public Date getDateLancement() {
		return dateLancement;
	}


	public void setDateLancement(Date dateLancement) {
		this.dateLancement = dateLancement;
	}


	public Date getDateEmbauche() {
		return dateEmbauche;
	}


	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}


	public Double getCoutEmbauche() {
		return coutEmbauche;
	}


	public void setCoutEmbauche(Double coutEmbauche) {
		this.coutEmbauche = coutEmbauche;
	}


	public String getDuree() {
		return duree;
	}


	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getMotifRecretement() {
		return motifRecretement;
	}


	public void setMotifRecretement(String motifRecretement) {
		this.motifRecretement = motifRecretement;
	}


	public String getRecruteur() {
		return recruteur;
	}


	public void setRecruteur(String recruteur) {
		this.recruteur = recruteur;
	}


	public String getModeRecretement() {
		return modeRecretement;
	}


	public void setModeRecretement(String modeRecretement) {
		this.modeRecretement = modeRecretement;
	}


	public boolean isAccepted() {
		return isAccepted;
	}


	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}


	public String getStatusPropo() {
		return statusPropo;
	}


	public void setStatusPropo(String statusPropo) {
		this.statusPropo = statusPropo;
	}
	
	
    
}