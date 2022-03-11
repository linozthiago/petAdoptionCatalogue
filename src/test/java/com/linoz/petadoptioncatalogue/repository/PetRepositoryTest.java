package com.linoz.petadoptioncatalogue.repository;

import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.util.PetCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;
import java.util.Optional;

/**
 * Created by linoz on 12/23/21
 */
@DataMongoTest
class PetRepositoryTest {

    private Pet petToBeSaved;
    private Pet petSaved;

    @Autowired
    private PetRepository petRepository;

    @BeforeEach
    public void init() {
        this.petToBeSaved = PetCreator.createPet();
        this.petSaved = petRepository.save(petToBeSaved);
    }

    @Test
    void savePersistPetWhenSuccessful() {
        Assertions.assertThat(petSaved).isNotNull();
        Assertions.assertThat(petSaved.getName()).isEqualTo(petToBeSaved.getName());
        Assertions.assertThat(petSaved.getType().getName()).isEqualTo(petToBeSaved.getType().getName());
    }

    @Test
    void saveUpdatePetWhenSuccessful() {
        petSaved.setName("doguin updated test");
        final Pet petUpdated = petRepository.save(petSaved);

        Assertions.assertThat(petUpdated).isNotNull();
        Assertions.assertThat(petUpdated.getName()).isEqualTo(petSaved.getName());
    }

    @Test
    void removePetWhenSuccessful() {
        petRepository.delete(petSaved);

        final Optional<Pet> petOptional = petRepository.findById(petSaved.getId());
        Assertions.assertThat(petOptional).isEmpty();
    }

    @Test
    void findByPetNameWhenSuccessful() {
        final Optional<Pet> pets = petRepository
                .findByName(petSaved.getName())
                .stream().findFirst();

        Assertions.assertThat(pets).isNotEmpty();
        Assertions.assertThat(pets.get().getName()).contains(petSaved.getName());
    }

    @Test
    void findByPetIdWhenSuccessful() {
        final Optional<Pet> petFound = petRepository
                .findById(petSaved.getId());

        Assertions.assertThat(petFound).isNotEmpty();
        Assertions.assertThat(petFound.get().getId()).isEqualTo(petSaved.getId());
    }

    @Test
    void findByNameReturnEmptyListWhenNotFound() {
        final List<Pet> pets = petRepository.findByName("pet doesn't exist");

        Assertions.assertThat(pets).isEmpty();
    }

    @Test
    void findByIdReturnEmptyWhenNotFound() {
        final Optional<Pet> pet = petRepository.findById("123k");

        Assertions.assertThat(pet).isEmpty();
    }

}
