package com.linoz.petadoptioncatalogue.dto;

import com.linoz.petadoptioncatalogue.domain.PetCategory;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by linoz on 12/20/21
 */
@Getter
public class PetCategoryDTO {
    private String id;
    private String name;

    @Autowired
    private PetCategory petCategory;

    public PetCategory createPetCategory() {
        return petCategory.builder()
                .name(name)
                .build();

    }

    public PetCategory updatePetCategory() {
        return petCategory.builder()
                .id(id)
                .name(name)
                .build();
    }

    public PetCategory deletePetCategory() {
        return PetCategory.builder()
                .id(id)
                .build();
    }
}
