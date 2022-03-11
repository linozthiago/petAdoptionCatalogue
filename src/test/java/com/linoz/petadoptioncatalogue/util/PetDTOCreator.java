package com.linoz.petadoptioncatalogue.util;

import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.domain.PetCategory;
import com.linoz.petadoptioncatalogue.dto.PetDTO;

/**
 * Created by linoz on 1/14/22
 */
public class PetDTOCreator {

    public static PetDTO create() {
        final Pet petCreator = PetCreator.createPet();
        PetDTO dto = new PetDTO();

        dto.setName(petCreator.getName());
        dto.setType(petCreator.getType());
        dto.setAge(5);

        return dto;
    }

    public static PetDTO update() {
        final Pet petCreator = PetCreator.createPet();
        PetDTO dto = new PetDTO();

        dto.setId(petCreator.getId());
        dto.setName("new pet name");
        dto.setType(petCreator.getType());
        dto.setAge(petCreator.getAge());

        return dto;
    }
}
