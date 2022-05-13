package com.pet.app.delegate;

import com.pet.app.service.request.PetRequest;
import com.pet.app.service.response.Response;

public interface PetDelegate {

	public Response findAllPets();
	public Response createPet(PetRequest petRequest);
	
}
