package com.linoz.petadoptioncatalogue.builder;

import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.domain.PetCategory;

/**
 * Interface of build pattern
 */
public interface PetBuilder {

    public PetBuilder buildId(String id);

    public PetBuilder buildName(String name);

    public PetBuilder buildType(PetCategory petCategory);

    public PetBuilder buildAge(int age);

    public Pet getPet();
}
