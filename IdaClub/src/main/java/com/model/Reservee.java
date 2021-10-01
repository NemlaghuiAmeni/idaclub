package com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Reservee {
	@Id
	private long idR = 0;
	private String diplome;
	private String nom;
	private String prenom;
	private String adresse;
	private String mail;
	private String type;

	

	public Reservee(long idR, String diplome, String nom, String prenom, String adresse, String mail, String type) {
		super();
		this.idR = idR;
		this.diplome = diplome;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mail = mail;
		this.type = type;
	}
	public Reservee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdR() {
		return idR;
	}
	public void setIdR(long idR) {
		this.idR = idR;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
