package com.linoz.petadoptioncatalogue.controller;

import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.dto.PetDTO;
import com.linoz.petadoptioncatalogue.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by linoz on 10/6/21
 */
@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService service;

    @GetMapping("/all")
    public List<Pet> listAllPets() {
        return service.findAll();
    }

    @GetMapping("/searchFor/{name}")
    public List<Pet> findByName(@PathVariable("name") String name) {
        return service.findPetByName(name);
    }

    @PostMapping("/create")
    public ResponseEntity<Pet> create(@RequestBody PetDTO petDTO) {
        return new ResponseEntity<>(service.save(petDTO.createPet().build()), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> remove(@RequestBody PetDTO petDTO) {
        service.delete(petDTO.removePet().build());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody PetDTO petDTO) {
        service.update(petDTO.updatePet().build());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
