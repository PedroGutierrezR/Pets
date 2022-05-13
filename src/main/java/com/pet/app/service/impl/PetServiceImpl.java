package com.pet.app.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.app.repository.PetRepository;
import com.pet.app.repository.model.Pet;
import com.pet.app.service.PetService;
import com.pet.app.service.request.PetRequest;
import com.pet.app.service.response.Response;

@Service("petService")
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepository;
	
	@Override
	public Response findAllPets() {
	
		List<Pet> pets = new ArrayList<Pet>();
		
		Iterator<Pet> iterator = petRepository.findAll().iterator();
		iterator.forEachRemaining(pets::add);
		
		Response response = new Response();
		response.setBody(pets);
		response.setMessage("Done");		
		
		return response;
	}

	@Override
	public Response createPet(PetRequest petRequest) {
		
		Pet pet = new Pet();
		pet.setName(petRequest.getName());
		pet.setType(petRequest.getType());
		pet.setOwner(petRequest.getOwner());
		pet.setDetail(petRequest.getDetail());
		pet.setStatus(petRequest.getStatus());
		
		petRepository.save(pet);
		
		List<Pet> pets = new ArrayList<Pet>();
		
		Iterator<Pet> iterator = petRepository.findAll().iterator();
		iterator.forEachRemaining(pets::add);
		
		Response response = new Response();
		response.setBody(pets);
		response.setMessage("Done");		
		
		return response;
	}

}
