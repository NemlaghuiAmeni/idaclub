package com.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Reponse;
import com.model.commentaire;

@Repository
public interface ReponseRepository extends MongoRepository<Reponse, String> {

}
