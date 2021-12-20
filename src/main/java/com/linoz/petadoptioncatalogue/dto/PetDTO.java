package com.linoz.petadoptioncatalogue.dto;

import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.domain.PetCategory;
import lombok.Getter;

/**
 * Created by linoz on 12/17/21
 */

@Getter
public class PetDTO {
    private String id;
    private String name;
    private PetCategory type;
    private int age;

    /**
     * create a new pet
     *
     * @return Pet
     */
    public Pet exchangeToCreatePet() {
        return new Pet(name, type, age);
    }

    /**
     * update or delete the pet
     *
     * @return Pet
     */
    public Pet exchangeToUpdateOrRemovePet() {
        return new Pet(id, name, type, age);
    }
}
