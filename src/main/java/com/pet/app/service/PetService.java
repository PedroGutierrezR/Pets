package com.pet.app.service;

import com.pet.app.service.request.PetRequest;
import com.pet.app.service.response.Response;

public interface PetService {

	public Response findAllPets();
	public Response createPet(PetRequest petRequest);
	
}
