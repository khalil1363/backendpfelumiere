package com.supportportal.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties("stage.stagiaires")
public class Stagier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStagier;
    private String nomPrenom;
    private String institut;
    private String diplome;
    private  String societe;
   
	private String specialite;
    private String cin;
    private String tel;
    
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER) // Optional: Cascade updates to Stagier on Employee save
    @JoinColumn(name = "idEmployee", nullable = false) // Foreign key to Employee (main supervisor)
    private Employee superviseur;
    
    
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER) // Optional: Cascade updates to Stagier on Stage save
    @JoinColumn(name = "idStage", nullable = false) // Foreign key to Stage
    @JsonIgnoreProperties("stagiaires")
    private Stage stage;
    
	public Long getIdStagier() {
		return idStagier;
	}
	public void setIdStagier(Long idStagier) {
		this.idStagier = idStagier;
	}
	public String getNomPrenom() {
		return nomPrenom;
	}
	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}
	public String getInstitut() {
		return institut;
	}
	public void setInstitut(String institut) {
		this.institut = institut;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Employee getSuperviseur() {
		return superviseur;
	}
	public void setSuperviseur(Employee superviseur) {
		this.superviseur = superviseur;
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	 public String getSociete() {
			return societe;
		}
		public void setSociete(String societe) {
			this.societe = societe;
		}
	public Stagier(Long idStagier, String nomPrenom, String institut, String societe, String diplome, String specialite, String cin,
			String tel, Employee superviseur, Stage stage) {
		super();
		this.idStagier = idStagier;
		this.nomPrenom = nomPrenom;
		this.institut = institut;
		this.diplome = diplome;
		this.specialite = specialite;
		this.cin = cin;
		this.tel = tel;
		this.superviseur = superviseur;
		this.stage = stage;
		this.societe=societe;	}
	public Stagier() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}