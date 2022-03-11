package com.linoz.petadoptioncatalogue.repository;

import com.linoz.petadoptioncatalogue.domain.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linoz on 9/30/21
 */

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {

    @Query("{name:'?0'}")
    List<Pet> findByName(String name);

    public long count();
}
