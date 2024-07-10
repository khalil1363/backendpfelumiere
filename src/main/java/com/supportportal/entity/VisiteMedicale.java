package com.supportportal.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class VisiteMedicale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mat;
    private String ste;
    private String nomPrenom;
    private String post;
    private String site;
    private Date dateEmbauche;
    private String typeDeSuivi;
    private String typeDeVisite;
    private Date dateVisite;
    private String renouvelle;
    private String commentaire;
    private String observation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getNomPrenom() {
		return nomPrenom;
	}
	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public String getTypeDeSuivi() {
		return typeDeSuivi;
	}
	public void setTypeDeSuivi(String typeDeSuivi) {
		this.typeDeSuivi = typeDeSuivi;
	}
	public String getTypeDeVisite() {
		return typeDeVisite;
	}
	public void setTypeDeVisite(String typeDeVisite) {
		this.typeDeVisite = typeDeVisite;
	}
	public Date getDateVisite() {
		return dateVisite;
	}
	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}
	public String getRenouvelle() {
		return renouvelle;
	}
	public void setRenouvelle(String renouvelle) {
		this.renouvelle = renouvelle;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public VisiteMedicale(Long id, String mat, String ste, String nomPrenom, String post, String site,
			Date dateEmbauche, String typeDeSuivi, String typeDeVisite, Date dateVisite, String renouvelle,
			String commentaire, String observation) {
		super();
		this.id = id;
		this.mat = mat;
		this.ste = ste;
		this.nomPrenom = nomPrenom;
		this.post = post;
		this.site = site;
		this.dateEmbauche = dateEmbauche;
		this.typeDeSuivi = typeDeSuivi;
		this.typeDeVisite = typeDeVisite;
		this.dateVisite = dateVisite;
		this.renouvelle = renouvelle;
		this.commentaire = commentaire;
		this.observation = observation;
	}
	public VisiteMedicale() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
    
}