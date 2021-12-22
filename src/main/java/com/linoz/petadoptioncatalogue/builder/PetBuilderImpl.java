package com.linoz.petadoptioncatalogue.builder;

import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.domain.PetCategory;

/**
 * Created by linoz on 12/21/21
 *
 * Didn't use the lombok Builder to understand the builder pattern
 */
public class PetBuilderImpl implements PetBuilder{

    private Pet pet;

    public PetBuilderImpl() {
        this.pet = new Pet();
    }

    @Override
    public void buildId(String id) {
        this.pet.setId(id);
    }

    @Override
    public void buildName(String name) {
        this.pet.setName(name);
    }

    @Override
    public void buildType(PetCategory petCategory) {
        this.pet.setType(petCategory);
    }

    @Override
    public void buildAge(int age) {
        this.pet.setAge(age);
    }

    @Override
    public Pet getPet() {
        return this.pet;
    }
}
