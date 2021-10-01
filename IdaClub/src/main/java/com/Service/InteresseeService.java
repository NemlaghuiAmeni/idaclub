package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.model.Interessee;
import com.model.commentaire;
@Repository
public class InteresseeService {
	@Autowired
	private MongoTemplate MongoTemplate;
	
	public Interessee save  (Interessee inter) {
		if (inter.getIdInt() == -1 || inter.getIdInt() == 0) {
			List listcomm = getAllinteressee();
			int fin =listcomm.size();
			inter.setIdInt(fin + 1);
			MongoTemplate.save(inter);
		} else {
			deleteInteressee(inter.getIdInt());

			MongoTemplate.save(inter);
		}
		return inter;
	}
	
	
	public List<Interessee> getAllinteressee() {
		return MongoTemplate.findAll(Interessee.class);
	}

	public Interessee getById(long id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));

		return MongoTemplate.findOne(query, Interessee.class);

	}

	public void deleteInteressee(Interessee inter) {
		MongoTemplate.remove(inter);

	}

	public Interessee deleteInteressee(long id) {

		Interessee inter = getById(id);
		if (inter == null) {
			return null;
		} else {
			deleteInteressee(inter);
		
			return inter;
		}

	}

}
