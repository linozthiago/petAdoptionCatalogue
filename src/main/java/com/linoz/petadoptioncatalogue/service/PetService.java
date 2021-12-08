package com.linoz.petadoptioncatalogue.service;

import com.linoz.petadoptioncatalogue.exception.NotFoundRequestException;
import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by linoz on 10/4/21
 */
@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public void save(Pet pet) {
        petRepository.save(pet);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public List<Pet> findByName(String name) {
        return petRepository.findPetByName(name);
     }

    public void delete (Pet pet) {
        final Pet petFound = findById(pet.getId());
        if(petFound != null) {
            petRepository.delete(pet);
        }
    }

    public void update(Pet pet) {
        final Pet petFound = findById(pet.getId());
        if(petFound != null) {
            save(pet);
        }
    }

    private Pet findById(String id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new NotFoundRequestException("Pet not found"));
    }
}