package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Repository.CommentaireRepository;
import com.Repository.ReponseRepository;
import com.Service.CommentaireService;
import com.Service.ReponseService;
import com.model.Reponse;

import com.model.commentaire;

@CrossOrigin(origins = "*")
@RestController
public class ReponseController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	private ReponseService RespService;
	@Autowired
	private ReponseRepository RespRepository;
	@RequestMapping(value = "Reponse/all", method = RequestMethod.GET)
	public List<Reponse> getAllReponses(Reponse reponse) {
		LOG.info("Getting all resp.");
		return RespRepository.findAll();
	}
	@RequestMapping(value = "/reponse", method = RequestMethod.POST)
	public Reponse add(@RequestBody Reponse reponse) {

		LOG.info("saving comment");

		return RespService.addReponse(reponse);

	}

	@DeleteMapping("reponse/{id}")
	public ResponseEntity<Void> deleteComment(@PathVariable long id) {
		Reponse reponse = RespService.deleteResponse(id);
		if (reponse != null) {
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();
	}

	
}
