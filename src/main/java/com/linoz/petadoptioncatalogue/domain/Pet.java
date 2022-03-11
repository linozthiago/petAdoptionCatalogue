package com.linoz.petadoptioncatalogue.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by linoz on 9/30/21
 */

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "pets")
public class Pet {
    @Id
    private String id;
    @NotEmpty(message="The pet name cannot be empty")
    @NotNull(message="The pet name cannot be null")
    private String name;
    private PetCategory type;
    private int age;

    public Pet(String name, PetCategory type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }
}
