package com.pet.app.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "pet_id_seq", initialValue = 1, sequenceName = "pet_id_seq", allocationSize = 1)
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_id_seq")
	@Column(name = "id_pet")
	private Long id;
	private String name;
	private String type;
	private String owner;
	private String detail;
	private String status;
	
}
