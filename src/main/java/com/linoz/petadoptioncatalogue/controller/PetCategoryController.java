package com.linoz.petadoptioncatalogue.controller;

import com.linoz.petadoptioncatalogue.domain.PetCategory;
import com.linoz.petadoptioncatalogue.dto.PetCategoryDTO;
import com.linoz.petadoptioncatalogue.service.PetCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by linoz on 12/9/21
 */
@RestController
@RequestMapping("/api/petsCategory")
@RequiredArgsConstructor
public class PetCategoryController {

    @Autowired
    private final PetCategoryService service;

    @GetMapping("/all")
    public List<PetCategory> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody PetCategoryDTO petCategoryDTO) {
        service.save(petCategoryDTO.createPetCategory());
    }

    @PutMapping("/update")
    public void update(@RequestBody PetCategoryDTO petCategoryDTO) {
        service.update(petCategoryDTO.updatePetCategory());
    }

    @DeleteMapping("/remove")
    public void remove(@RequestBody PetCategoryDTO petCategoryDTO) {
        service.delete(petCategoryDTO.deletePetCategory());
    }

}
