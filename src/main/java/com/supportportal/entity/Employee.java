package com.supportportal.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;
    private String nomPrenom;
    private String departement;
    private String fonction;
    private String site;
    private String tel;
    private String mat;
    private String post;
    

    @ManyToMany(cascade = CascadeType.ALL) // ManyToMany relationship with Employee
    @JoinTable(name = "stagier_employee", // Join table for the relationship
        joinColumns = @JoinColumn(name = "idStagier"),
        inverseJoinColumns = @JoinColumn(name = "idEmployee"))
    private Set<Employee> contacts;
    
   
    
    public Employee() {
    }


    
    
    
    
    
    public Employee(Long idEmployee, String nomPrenom, String departement, String fonction, String site, String tel,
			String mat, String post) {
		super();
		this.idEmployee = idEmployee;
		this.nomPrenom = nomPrenom;
		this.departement = departement;
		this.fonction = fonction;
		this.site = site;
		this.tel = tel;
		this.mat = mat;
		this.post = post;
	
	}







	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Set<Employee> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Employee> contacts) {
		this.contacts = contacts;
	}

	public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }
}
