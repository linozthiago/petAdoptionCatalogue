package com.linoz.petadoptioncatalogue.dto;

import com.linoz.petadoptioncatalogue.builder.PetBuilder;
import com.linoz.petadoptioncatalogue.builder.PetBuilderImpl;
import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.domain.PetCategory;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by linoz on 12/17/21
 */

@Getter
@Setter
public class PetDTO {
    private String id;
    private String name;
    private PetCategory type;
    private int age;

    private final PetBuilder petBuilder;

    public PetDTO() {
        this.petBuilder = new PetBuilderImpl();
    }

    /**
     * builder of a new pet
     *
     * @return this
     */
    public PetDTO createPet() {
        petBuilder.buildName(name)
        .buildType(type)
        .buildAge(age);

        return this;
    }

    /**
     * builder of a pet to update
     *
     * @return this
     */
    public PetDTO updatePet() {
        petBuilder.buildId(id)
        .buildName(name)
        .buildType(type)
        .buildAge(age);

        return this;
    }

    /**
     * builder of a pet to remove
     *
     * @return this
     */
    public PetDTO removePet() {
        petBuilder.buildId(id);

        return this;
    }

    /**
     * build the pet from builders
     *
     * @return Pet
     */
    public Pet build() {
        return petBuilder.getPet();
    }
}
