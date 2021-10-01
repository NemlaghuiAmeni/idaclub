package com.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Document

public class Interessee {
	
	@Id
	private long idInt = 0;
	private String diplome;
	private String nom;
	private String prenom;
	private String adresse;
	private String mail;
	
	
	
	
	
	public Interessee(long idInt, String diplome, String nom, String prenom, String adresse, String mail) {
		super();
		this.idInt = idInt;
		this.diplome = diplome;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mail = mail;
	}
	public Interessee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdInt() {
		return idInt;
	}
	public void setIdInt(long idInt) {
		this.idInt = idInt;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	

}
