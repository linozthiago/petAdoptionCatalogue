package com.linoz.petadoptioncatalogue.builder;

import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.domain.PetCategory;

/**
 * Interface of build pattern
 */
public interface PetBuilder {

    public void buildId(String id);

    public void buildName(String name);

    public void buildType(PetCategory petCategory);

    public void buildAge(int age);

    public Pet getPet();
}
