package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.model.Reponse;
import com.model.commentaire;

@Repository
public class ReponseService {

	@Autowired
	private MongoTemplate MongoTemplate;
	private static int IdcourantReponse = 0;
	
	public List<Reponse> getAllreponse() {
		return MongoTemplate.findAll(Reponse.class);
	}
	
	
	public Reponse getById(long id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));

		return MongoTemplate.findOne(query, Reponse.class);

	}
	public void deleteReponse(Reponse reponse) {
		MongoTemplate.remove(reponse);

	}
	
	
	public Reponse deleteResponse(long id) {

		Reponse reponse = getById(id);
		if (reponse == null) {
			return null;
		} else {
			deleteReponse(reponse);
			System.out.println("reponse " + id + "est suprimer");
			return reponse;
		}

	}
	public Reponse findByid(long id) {

		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		System.out.println("the response is " + id);
		return (Reponse) MongoTemplate.find(query, Reponse.class);
	}

	/// Save response
		public Reponse save(Reponse R) {
			if (R.getId() == -1 || R.getId() == 0) {
				List listResp = getAllreponse();
				int fin =listResp.size();
				R.setId(fin + 1);
				MongoTemplate.save(R);
			} else {
				deleteResponse(R.getId());

				// comm.add(C);

				MongoTemplate.save(R);
			}
			return R;
		}
		
		// Ajouter Reponse
		public Reponse addReponse(Reponse reponse) {
			long id = reponse.getId();
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(id));
			save(reponse);
			return reponse;

		}


}
