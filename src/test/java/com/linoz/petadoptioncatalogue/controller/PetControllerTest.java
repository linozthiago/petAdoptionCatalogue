package com.linoz.petadoptioncatalogue.controller;

import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.service.PetService;
import com.linoz.petadoptioncatalogue.util.PetCreator;
import com.linoz.petadoptioncatalogue.util.PetDTOCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)
class PetControllerTest {
    @InjectMocks
    PetController petController;

    @Mock
    PetService petServiceMock;

    private List<Pet> pets;

    @BeforeEach
    void setUp() {
        pets = new ArrayList<>(Arrays.asList(PetCreator.createPet()));
        BDDMockito.when(petServiceMock.findAll())
                .thenReturn(pets);
        BDDMockito.when(petServiceMock.findPetByName(ArgumentMatchers.anyString()))
                .thenReturn(pets);
        BDDMockito.when(petServiceMock.save(ArgumentMatchers.any(Pet.class)))
                .thenReturn(PetCreator.createPet());
        BDDMockito.doNothing().when(petServiceMock).delete(ArgumentMatchers.any(Pet.class));
        BDDMockito.doNothing().when(petServiceMock).update(ArgumentMatchers.any(Pet.class));
    }

    @Test
    void returnListOfPetsWhenSuccessful() {
        final String expectedName = PetCreator.createPet().getName();
        final List<Pet> petsFound = petController.listAllPets();

        Assertions.assertThat(petsFound)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(petsFound.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    void returnListOfPetsFindingByNameWhenSuccessful() {
        final String expectedName = PetCreator.createPet().getName();
        final List<Pet> petFound = petController.findByName("pet");

        Assertions.assertThat(petFound)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(petFound.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    void returnEmptyListOfPetWhenAnimeIsNotFound() {
        BDDMockito.when(petServiceMock.findPetByName(ArgumentMatchers.anyString()))
                .thenReturn(Collections.emptyList());

        final List<Pet> petsEmptyList = petController.findByName("pet");

        Assertions.assertThat(petsEmptyList)
                .isNotNull()
                .isEmpty();

    }

    @Test
    void savePetWithoutThrowingExceptionWhenSuccessful() {
        Assertions.assertThatCode(() -> {
            petController.create(PetDTOCreator.create());
        }).doesNotThrowAnyException();

    }

    @Test
    void removePetWithoutThrowingExceptionWhenSuccessful() {
        Assertions.assertThatCode(() -> {
            petController.remove(PetDTOCreator.create());
        }).doesNotThrowAnyException();

    }

    @Test
    void updatePetSuccessful() {
        Assertions.assertThatCode(() -> {
            petController.update(PetDTOCreator.update());
        }).doesNotThrowAnyException();

        final ResponseEntity<Void> responseEntity = petController.update(PetDTOCreator.update());

        Assertions.assertThat(responseEntity).isNotNull();
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

    }
}