package com.linoz.petadoptioncatalogue.repository;

import com.linoz.petadoptioncatalogue.domain.PetCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetCategoryRepository extends MongoRepository<PetCategory, String> {
}
