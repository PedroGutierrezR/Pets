package com.pet.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.pet.app.repository.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Integer> {

}
