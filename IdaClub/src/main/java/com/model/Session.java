package com.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Session {

	@Id
	private Integer id = 0;

	private String titre;
	private String ref;
	private Date Datedebut = new Date();
	private Date Datefin = new Date();
	private String Code;
	private String formation;
	private int nbreHeures;
	private int effectif;
	private String programme;
	private int prix;
	private String type;

	
	private byte[] photo;
	private String fileName;
	private static Integer idcourant = 0;
	private int nbrinter;
	private int nbrResevee;
	private int nbrRes;
	private long counter ;
	@DBRef
	private Collection<Interessee> Inter = new ArrayList<>();
	@DBRef
	private Collection<Reservee> res = new ArrayList<>();
	
	@DBRef
	private Collection<commentaire> commentaires = new ArrayList<>();

	private Collection<User> Users = new ArrayList<>();
	
	
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	




	public Session(Integer id, String titre, String ref, Date datedebut, Date datefin, String code, String formation,
			int nbreHeures, int effectif, String programme, int prix, String type, byte[] photo, String fileName,
			int nbrinter, int nbrResevee, int nbrRes, long counter, Collection<Interessee> inter,
			Collection<Reservee> res, Collection<commentaire> commentaires, Collection<User> users) {
		super();
		this.id = id;
		this.titre = titre;
		this.ref = ref;
		Datedebut = datedebut;
		Datefin = datefin;
		Code = code;
		this.formation = formation;
		this.nbreHeures = nbreHeures;
		this.effectif = effectif;
		this.programme = programme;
		this.prix = prix;
		this.type = type;
		this.photo = photo;
		this.fileName = fileName;
		this.nbrinter = nbrinter;
		this.nbrResevee = nbrResevee;
		this.nbrRes = nbrRes;
		this.counter = counter;
		Inter = inter;
		this.res = res;
		this.commentaires = commentaires;
		Users = users;
	}







	public int getNbrResevee() {
		return nbrResevee;
	}


	public void setNbrResevee(int nbrResevee) {
		this.nbrResevee = nbrResevee;
	}


	public int getNbrRes() {
		return nbrRes;
	}

	public void setNbrRes(int nbrRes) {
		this.nbrRes = nbrRes;
	}

	public Collection<Reservee> getRes() {
		return res;
	}

	public void setRes(Collection<Reservee> res) {
		this.res = res;
	}



	

	
	
	
	
	
	public Collection<Interessee> getInter() {
		return Inter;
	}

	public void setInter(Collection<Interessee> inter) {
		Inter = inter;
	}

	public int getnbrinter() {
		return nbrinter;
	}

	public void setnbrinter(int nbrinter) {
		this.nbrinter = nbrinter;
	}

	public Collection<commentaire> getCommentaires() {

		return commentaires;
	}

	public void setCommentaires(Collection<commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public int getNbreHeures() {
		return nbreHeures;
	}

	public void setNbreHeures(int nbreHeures) {
		this.nbreHeures = nbreHeures;
	}

	public int getEffectif() {
		return effectif;
	}

	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public static Integer getIdcourant() {
		return idcourant;
	}

	public static void setIdcourant(Integer idcourant) {
		Session.idcourant = idcourant;
	}

	public Collection<User> getUsers() {
		return Users;
	}
	public void setUsers(Collection<User> users) {
		Users = users;
	}

	public long getCounter() {
		return counter;
	}

	public void setCounter(long counter) {
		this.counter = counter;
	}


	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
	}


	public Date getDatedebut() {
		return Datedebut;
	}


	public void setDatedebut(Date datedebut) {
		Datedebut = datedebut;
	}


	public Date getDatefin() {
		return Datefin;
	}


	public void setDatefin(Date datefin) {
		Datefin = datefin;
	}


	public String getCode() {
		return Code;
	}


	public void setCode(String code) {
		Code = code;
	}
	
	

}


