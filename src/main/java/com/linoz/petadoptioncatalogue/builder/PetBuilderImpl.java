package com.linoz.petadoptioncatalogue.builder;

import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.domain.PetCategory;

/**
 * Created by linoz on 12/21/21
 *
 * Didn't use the lombok Builder to understand the builder pattern
 */
public class PetBuilderImpl implements PetBuilder{

    private final Pet pet;

    public PetBuilderImpl() {
        this.pet = new Pet();
    }

    @Override
    public PetBuilder buildId(String id) {
        this.pet.setId(id);
        return this;
    }

    @Override
    public PetBuilder buildName(String name) {
        this.pet.setName(name);
        return this;
    }

    @Override
    public PetBuilder buildType(PetCategory petCategory) {
        this.pet.setType(petCategory);
        return this;
    }

    @Override
    public PetBuilder buildAge(int age) {
        this.pet.setAge(age);
        return this;
    }

    @Override
    public Pet getPet() {
        return this.pet;
    }
}
