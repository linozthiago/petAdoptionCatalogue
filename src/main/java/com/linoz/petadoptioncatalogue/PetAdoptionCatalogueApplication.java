package com.linoz.petadoptioncatalogue;

import com.linoz.petadoptioncatalogue.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PetAdoptionCatalogueApplication {

	@Autowired
	PetRepository petRepository;

	public static void main(String[] args) {
		SpringApplication.run(PetAdoptionCatalogueApplication.class, args);
	}

}
