package com.supportportal.entity;

import java.sql.Date;


import javax.persistence.*;

@Entity
public class PropositionOffre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOffreProp;
    private String departement;
    private String jobTitre;
    private Date dateLancement;
  
    @Enumerated
    private PropositionOffreRecruteur recruteur; 
    
    
    private String motiveRecretement;
    
    @Enumerated
    private PropositionOffreMode modeRecretement;
    
    @Enumerated
    private PropositionOffreStatus status;
    
    private Date dateEmbauche;
    private Double coutEmbauche;
    private Integer duree;
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
	public String getJobTitre() {
		return jobTitre;
	}
	public void setJobTitre(String jobTitre) {
		this.jobTitre = jobTitre;
	}
	public Date getDateLancement() {
		return dateLancement;
	}
	public void setDateLancement(Date dateLancement) {
		this.dateLancement = dateLancement;
	}
	public PropositionOffreRecruteur getRecruteur() {
		return recruteur;
	}
	public void setRecruteur(PropositionOffreRecruteur recruteur) {
		this.recruteur = recruteur;
	}
	public String getMotiveRecretement() {
		return motiveRecretement;
	}
	public void setMotiveRecretement(String motiveRecretement) {
		this.motiveRecretement = motiveRecretement;
	}
	public PropositionOffreMode getModeRecretement() {
		return modeRecretement;
	}
	public void setModeRecretement(PropositionOffreMode modeRecretement) {
		this.modeRecretement = modeRecretement;
	}
	public PropositionOffreStatus getStatus() {
		return status;
	}
	public void setStatus(PropositionOffreStatus status) {
		this.status = status;
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
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public PropositionOffre(Long idOffreProp, String departement, String jobTitre, Date dateLancement,
			PropositionOffreRecruteur recruteur, String motiveRecretement, PropositionOffreMode modeRecretement,
			PropositionOffreStatus status, Date dateEmbauche, Double coutEmbauche, Integer duree) {
		super();
		this.idOffreProp = idOffreProp;
		this.departement = departement;
		this.jobTitre = jobTitre;
		this.dateLancement = dateLancement;
		this.recruteur = recruteur;
		this.motiveRecretement = motiveRecretement;
		this.modeRecretement = modeRecretement;
		this.status = status;
		this.dateEmbauche = dateEmbauche;
		this.coutEmbauche = coutEmbauche;
		this.duree = duree;
	}
	public PropositionOffre() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

    
    
}