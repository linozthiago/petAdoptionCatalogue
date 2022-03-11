package com.linoz.petadoptioncatalogue.service;

import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.domain.PetCategory;
import com.linoz.petadoptioncatalogue.exception.NotFoundRequestException;
import com.linoz.petadoptioncatalogue.repository.PetCategoryRepository;
import com.linoz.petadoptioncatalogue.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by linoz on 10/4/21
 */
@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final PetCategoryRepository categoryRepository;

    public Pet save(Pet pet) {
        findCategory(pet.getType().getId());

        return petRepository.save(pet);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public List<Pet> findPetByName(String name) {
        return petRepository.findByName(name);
     }

    public void delete (Pet pet) {
        findById(pet.getId());

        petRepository.delete(pet);
    }

    public void update(Pet pet) {
        findById(pet.getId());
        findCategory(pet.getType().getId());

        petRepository.save(pet);
    }

    private Pet findById(String id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new NotFoundRequestException("Pet not found"));
    }

    private PetCategory findCategory(String id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundRequestException("Category not found"));
    }
}
