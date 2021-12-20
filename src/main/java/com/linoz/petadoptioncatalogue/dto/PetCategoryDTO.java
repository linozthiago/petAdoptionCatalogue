package com.linoz.petadoptioncatalogue.dto;

import com.linoz.petadoptioncatalogue.domain.PetCategory;
import lombok.Getter;

/**
 * Created by linoz on 12/20/21
 */
@Getter
public class PetCategoryDTO {
    private String id;
    private String name;

    public PetCategory exchangeToCretaPetCategory() {
        return new PetCategory(name);
    }

    public PetCategory exchangeToUpdateOrDeletePetCategory() {
        return new PetCategory(id, name);
    }
}
