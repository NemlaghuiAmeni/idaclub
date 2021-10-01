package com.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.model.Reponse;
import com.model.Session;
import com.model.commentaire;

@Repository
public class CommentaireService {
	@Autowired
	private ReponseService reponseS;

	@Autowired
	private MongoTemplate MongoTemplate;
	private static int Idcourant = 0;

	// Get All
	public List<commentaire> getAllcomment() {
		return MongoTemplate.findAll(commentaire.class);
	}

	public commentaire getById(long id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));

		return MongoTemplate.findOne(query, commentaire.class);

	}

	public void deleteComment(commentaire comment) {
		MongoTemplate.remove(comment);

	}

	public commentaire deleteComm(long id) {

		commentaire comment = getById(id);
		if (comment == null) {
			return null;
		} else {
			deleteComment(comment);
			System.out.println("comment " + id + "est suprimer");
			return comment;
		}

	}

	
	public commentaire findByid(long id) {

		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		System.out.println("the comment is " + id);
		return (commentaire) MongoTemplate.find(query, commentaire.class);
	}

	/// Save Commnetaire
	public commentaire save(commentaire C) {
		if (C.getId() == -1 || C.getId() == 0) {
			List listcomm = getAllcomment();
			int fin =listcomm.size();
			C.setId(fin + 1);
			MongoTemplate.save(C);
		} else {
			deleteComm(C.getId());

			// comm.add(C);

			MongoTemplate.save(C);
		}
		return C;
	}

	// Ajouter Commmentaire
	public commentaire addcomment(commentaire comment) {
		long id = comment.getId();
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		save(comment);
		return comment;

	}
	
	// Ajouter reponse to Commmentaire
Collection<Reponse> list = new ArrayList<Reponse>();
	public commentaire addReptoComment(long idc, Reponse rep) {
		commentaire C = getById(idc);
		Reponse r = reponseS.save(rep);
		long idr = r.getId();
		list = C.getReponse();
		boolean test = true;

		for (Iterator<Reponse> iterator = list.iterator(); iterator.hasNext();) {
			Reponse value = iterator.next();

			if (value.getId() == idr) {
				System.out.println(value.getId());
				test = false;
			}
		}
		if (test == true) {
		if(list.add(r)) {
			
			C.setNbrReponse(list.size());
		}
		MongoTemplate.save(C);
		} else {
			System.out.println("existe");
		}

		return C;

	}
	public commentaire deletecommentReponse(long idC,long id) {
		commentaire c1 =getById(idC);
	
	      list= c1.getReponse();
	

		for (Iterator<Reponse> iterator = list.iterator(); iterator.hasNext(); ) {
			Reponse value = iterator.next();
		    if (value.getId()==id) {
		        iterator.remove();
				c1.setNbrReponse(list.size()); 

		        

		    }
		    
		    
		}
		return MongoTemplate.save(c1);
		
		}




}