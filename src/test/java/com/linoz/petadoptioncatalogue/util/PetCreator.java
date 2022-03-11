package com.linoz.petadoptioncatalogue.util;

import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.domain.PetCategory;

/**
 * Created by linoz on 1/13/22
 */
public class PetCreator {

    /**
     * create one pet with category
     *
     * @return Pet
     */
    public static Pet createPet() {
        final PetCategory petCategory = PetCategory.builder()
                .id("123")
                .name("dog")
                .build();

        Pet pet = new Pet("doguin test",petCategory,5);
        return pet;
    }

    /**
     *
     * update pet's name
     *
     * @param pet
     * @param name
     * @return Pet
     */
    public static Pet updateNamePet(Pet pet, String name) {
        pet.setName(name);

        return pet;
    }
}
