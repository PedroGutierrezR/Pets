package com.pet.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pet.app.delegate.PetDelegate;
import com.pet.app.service.PetService;
import com.pet.app.service.request.PetRequest;
import com.pet.app.service.response.Response;

@Component("petDelegate")
public class PetDelegateImpl implements PetDelegate {

	@Autowired
	private PetService petService;
	
	@Override
	public Response findAllPets() {
		return petService.findAllPets();
	}

	@Override
	public Response createPet(PetRequest petRequest) {
		return petService.createPet(petRequest);
	}

}
