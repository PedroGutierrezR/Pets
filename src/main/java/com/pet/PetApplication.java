package com.pet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pet.app.repository.PetRepository;
import com.pet.app.repository.model.Pet;

@SpringBootApplication
public class PetApplication {

	private static final Logger logger = LoggerFactory.getLogger(PetApplication.class);

	@Autowired
	private PetRepository petRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PetApplication.class, args);
	}

	@Bean
	public CommandLineRunner createPet() {
		return (args) ->{
			
			Pet pet = new Pet();
			pet.setName("Peke");
			pet.setDetail("He barks a lots");
			pet.setOwner("Pauli");
			pet.setType("Dog");
			pet.setStatus("ADOPTED");
			
			Pet pet2 = new Pet();
			pet2.setName("Chimultrufia");
			pet2.setDetail("she is really filthy");
			pet2.setOwner("Esteban");
			pet2.setType("Dog");
			pet2.setStatus("ADOPTED");
			
			petRepository.save(pet);
			petRepository.save(pet2);
			
		};
	}
	
	@Bean
	public CommandLineRunner findAllPets() {
		return (args) ->{
			
			List<Pet> pets = new ArrayList<Pet>();
			Iterator<Pet> iterator = petRepository.findAll().iterator();
			iterator.forEachRemaining(pets::add);
			
			for (Pet pet : pets) {
				logger.info(pet.toString());
			}
			
		};
	}
	
}
