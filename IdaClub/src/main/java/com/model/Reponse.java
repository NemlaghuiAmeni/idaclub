package com.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Reponse {
	@Id
	private long id;
	private String msg;
	private String email;
	private Date date =new Date();
	private int iduser;
	@DBRef
	private commentaire comment;
	
	public Reponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reponse(long id, String msg, String email, Date date, int iduser, commentaire comment) {
		super();
		this.id = id;
		this.msg = msg;
		this.email = email;
		this.date = date;
		this.iduser = iduser;
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public commentaire getComment() {
		return comment;
	}

	public void setComment(commentaire comment) {
		this.comment = comment;
	}



	








}