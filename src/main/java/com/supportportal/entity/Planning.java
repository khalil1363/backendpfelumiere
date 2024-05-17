package com.supportportal.entity;


import java.util.Date;

import javax.persistence.*;
@Entity
public class Planning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanning;
    private String module;
    private Date annee;
    private String participants;
    private String departement;
    private String fonction;
    private String participation;
    private String feedback;
	public Long getIdPlanning() {
		return idPlanning;
	}
	public void setIdPlanning(Long idPlanning) {
		this.idPlanning = idPlanning;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public Date getAnnee() {
		return annee;
	}
	public void setAnnee(Date annee) {
		this.annee = annee;
	}
	public String getParticipants() {
		return participants;
	}
	public void setParticipants(String participants) {
		this.participants = participants;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getParticipation() {
		return participation;
	}
	public void setParticipation(String participation) {
		this.participation = participation;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Planning(Long idPlanning, String module, Date annee, String participants, String departement,
			String fonction, String participation, String feedback) {
		super();
		this.idPlanning = idPlanning;
		this.module = module;
		this.annee = annee;
		this.participants = participants;
		this.departement = departement;
		this.fonction = fonction;
		this.participation = participation;
		this.feedback = feedback;
	}
	public Planning() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}