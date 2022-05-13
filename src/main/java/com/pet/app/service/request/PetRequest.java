package com.pet.app.service.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetRequest {

	private Long id;
	private String name;
	private String type;
	private String owner;
	private String detail;
	private String status;
	
}
