package com.supportportal.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class OffreEmploi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOffreEmploi;
    
    private String departement;
    private String jobTitre;
    private Double coutEmbauche; 
    private String duree;
    
    private String motifRecretement;
    
    private Date dateLancement;
    private Date dateEmbauche;
    
    private String recruteur; 
    private String modeRecrutement;
    private String statusOffre;
    
    
    
    @ManyToMany(mappedBy = "offresEmploi")
    @JsonManagedReference // Serializes this side of the relationship normally
    private Set<Candidat> candidatures ;
  


	public OffreEmploi() {
		super();
	}
	
	
	public OffreEmploi(Long idOffreEmploi, String departement, String jobTitre, Double coutEmbauche, String duree,
			String motifRecretement, Date dateLancement, Date dateEmbauche, String recruteur, String modeRecretement,
			String statusOffre, Set<Candidat> candidatures) {
		super();
		this.idOffreEmploi = idOffreEmploi;
		this.departement = departement;
		this.jobTitre = jobTitre;
		this.coutEmbauche = coutEmbauche;
		this.duree = duree;
		this.motifRecretement = motifRecretement;
		this.dateLancement = dateLancement;
		this.dateEmbauche = dateEmbauche;
		this.recruteur = recruteur;
		this.modeRecrutement = modeRecretement;
		this.statusOffre = statusOffre;
		this.candidatures = candidatures;
	}




	public Long getIdOffreEmploi() {
		return idOffreEmploi;
	}

	public void setIdOffreEmploi(Long idOffreEmploi) {
		this.idOffreEmploi = idOffreEmploi;
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




	public String getRecruteur() {
		return recruteur;
	}




	public void setRecruteur(String recruteur) {
		this.recruteur = recruteur;
	}




	public String getModeRecretement() {
		return modeRecrutement;
	}




	public void setModeRecretement(String modeRecretement) {
		this.modeRecrutement = modeRecretement;
	}




	public Set<Candidat> getCandidatures() {
		return candidatures;
	}




	public void setCandidatures(Set<Candidat> candidatures) {
		this.candidatures = candidatures;
	}

	public String getStatusOffre() {
		return statusOffre;
	}

	public void setStatusOffre(String statusOffre) {
		this.statusOffre = statusOffre;
	}
	
	




    
	

}