package com.pet.app.ui.ws.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.app.delegate.PetDelegate;
import com.pet.app.service.request.PetRequest;
import com.pet.app.service.response.Response;

@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private PetDelegate petDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> findAllPets(){
		return new ResponseEntity<Response>(petDelegate.findAllPets(), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createPet(@RequestBody PetRequest petRequest){
		return new ResponseEntity<Response>(petDelegate.createPet(petRequest), HttpStatus.OK);
	}
	
}
