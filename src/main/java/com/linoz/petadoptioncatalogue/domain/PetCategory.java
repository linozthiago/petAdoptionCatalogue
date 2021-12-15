package com.linoz.petadoptioncatalogue.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by linoz on 12/9/21
 */
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "petsCategory")
public class PetCategory {
    @Id
    private String id;
    private String name;

    public PetCategory(String name) {
        this.name = name;
    }
}
