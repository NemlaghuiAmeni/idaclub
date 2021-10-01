package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.model.Reservee;


@Repository
public class ReserveeService {
	@Autowired
	private MongoTemplate MongoTemplate;
	
	public Reservee save  (Reservee res) {
		if (res.getIdR() == -1 || res.getIdR() == 0) {
			List listRES = getAllReservee();
			int fin =listRES.size();
			res.setIdR(fin + 1);
			MongoTemplate.save(res);
		} else {
			deleteReservee(res.getIdR());

			

			MongoTemplate.save(res);
		}
		return res;
	}
	
	
	public List<Reservee> getAllReservee() {
		return MongoTemplate.findAll(Reservee.class);
	}

	public Reservee getById(long id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));

		return MongoTemplate.findOne(query, Reservee.class);

	}

	public void deleteReservee(Reservee res) {
		MongoTemplate.remove(res);

	}

	public Reservee deleteReservee(long id) {

		Reservee inter = getById(id);
		if (inter == null) {
			return null;
		} else {
			
			deleteReservee(inter);
		
			return inter;
		}

	}


}
