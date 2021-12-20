package com.linoz.petadoptioncatalogue.controller;

import com.linoz.petadoptioncatalogue.domain.Pet;
import com.linoz.petadoptioncatalogue.dto.PetDTO;
import com.linoz.petadoptioncatalogue.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by linoz on 10/6/21
 */
@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {

    @Autowired
    private final PetService service;

    @GetMapping("/all")
    public List<Pet> listAllPets() {
        return service.findAll();
    }

    @GetMapping("/searchFor/{name}")
    public List<Pet> findByName(@PathVariable("name") String name) {
        return service.findByName(name);
    }

    @PostMapping("/create")
    public void create(@RequestBody PetDTO petDTO) {
        service.save(petDTO.exchangeToCreatePet());
    }

    @DeleteMapping("/remove")
    @ResponseBody
    public void remove(@RequestBody PetDTO petDTO) {
        service.delete(petDTO.exchangeToUpdateOrRemovePet());
    }

    @PutMapping("/update")
    public void update(@RequestBody PetDTO petDTO) {
        service.update(petDTO.exchangeToUpdateOrRemovePet());
    }
}
