package com.linoz.petadoptioncatalogue.service;

import com.linoz.petadoptioncatalogue.domain.PetCategory;
import com.linoz.petadoptioncatalogue.exception.NotFoundRequestException;
import com.linoz.petadoptioncatalogue.repository.PetCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by linoz on 12/9/21
 */

@Service
@RequiredArgsConstructor
public class PetCategoryService {

    private final PetCategoryRepository repository;

    public void save(PetCategory petCategory) {
        repository.save(petCategory);
    }

    public List<PetCategory> findAll() {
        return repository.findAll();
    }

    public void delete(PetCategory petCategory) {
        final PetCategory petCategoryFound = findById(petCategory.getId());

        if(petCategoryFound != null) {
            repository.delete(petCategory);
        }
    }

    public void update(PetCategory petCategory) {
        final PetCategory petCategoryFound = findById(petCategory.getId());

        if(petCategoryFound != null) {
            repository.save(petCategory);
        }
    }

    private PetCategory findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundRequestException("category not found"));
    }
}
