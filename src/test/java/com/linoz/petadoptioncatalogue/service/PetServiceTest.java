package com.linoz.petadoptioncatalogue.service;

import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.exception.NotFoundRequestException;
import com.linoz.petadoptioncatalogue.repository.PetCategoryRepository;
import com.linoz.petadoptioncatalogue.repository.PetRepository;
import com.linoz.petadoptioncatalogue.util.PetCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by linoz on 2/18/22
 */

@ExtendWith(SpringExtension.class)
public class PetServiceTest {

    @InjectMocks
    PetService petServiceMock;

    @Mock
    PetRepository petRepositoryMock;

    @Mock
    PetCategoryRepository petCategoryRepositoryMock;

    private List<Pet> pets;
    private Pet pet;

    @BeforeEach
    void setUp() {
        pet = PetCreator.createPet();
        BDDMockito.when(petRepositoryMock.save(ArgumentMatchers.any(Pet.class)))
                .thenReturn(pet);

        pets = new ArrayList<>(Arrays.asList(pet));
        BDDMockito.when(petRepositoryMock.findAll())
                .thenReturn(pets);
        BDDMockito.when(petRepositoryMock.findByName(pet.getName()))
                .thenReturn(pets);
        BDDMockito.when(petRepositoryMock.findById(pet.getId()))
                .thenReturn(Optional.ofNullable(pet));
        BDDMockito.when(petCategoryRepositoryMock.findById(ArgumentMatchers.anyString()))
                .thenReturn(Optional.ofNullable(pet.getType()));
        BDDMockito.doNothing().when(petRepositoryMock).delete(ArgumentMatchers.any(Pet.class));
    }

    @Test
    void saveReturnsPetWhenSuccessful() {
        final Pet expectedPetName = PetCreator.createPet();
        final Pet petCreated = petServiceMock.save(expectedPetName);

        Assertions.assertThat(petCreated).isNotNull();
        Assertions.assertThat(petCreated.getName()).isEqualTo(expectedPetName.getName());
    }

    @Test
    void savePetWithoutThrowingAnyException() {
        Assertions.assertThatCode(() -> {
                petServiceMock.save(PetCreator.createPet());
        }).doesNotThrowAnyException();
    }

    @Test
    void savePetWithoutCategoryThrowingNotFoundRequestException() {
        BDDMockito.when(petCategoryRepositoryMock.findById(ArgumentMatchers.anyString()))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> {
            petServiceMock.save(PetCreator.createPet());
        }).isInstanceOf(NotFoundRequestException.class);
    }

    @Test
    void findAllReturnsListWhenSuccessful() {
        final List<Pet> petsFound = petServiceMock.findAll();

        Assertions.assertThat(petsFound)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);
    }

    @Test
    void findAllReturnsEmptyListWhenDidNotFindAnyPet() {
        BDDMockito.when(petRepositoryMock.findAll())
                .thenReturn(Collections.emptyList());

        final List<Pet> petsFound = petServiceMock.findAll();

        Assertions.assertThat(petsFound)
                .isNotNull()
                .isEmpty();
    }

    @Test
    void findByNameReturnsListWhenSuccessful() {
        final String expectedName = pet.getName();
        final List<Pet> petList = petServiceMock.findPetByName(expectedName);

        Assertions.assertThat(petList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(petList.get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    void findByNameReturnsEmptyListWhenPetNotFound() {
        final List<Pet> petList = petServiceMock.findPetByName("pet name not created");

        Assertions.assertThat(petList)
                .isNotNull()
                .isEmpty();
    }

    @Test
    void deletePetWithoutThrowingAnyException() {
        Assertions.assertThatCode(() -> {
            petServiceMock.delete(pet);
        }).doesNotThrowAnyException();
    }

    @Test
    void updatePetNameWhenSuccessful() {
        Pet updatedPet = PetCreator.updateNamePet(pet, "doguim name updated");
        petServiceMock.update(updatedPet);

        Assertions.assertThat(updatedPet.getName()).isEqualTo(pet.getName());
    }
}
