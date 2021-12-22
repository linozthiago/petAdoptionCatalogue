package com.linoz.petadoptioncatalogue.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by linoz on 12/9/21
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "petsCategory")
public class PetCategory {
    @Id
    private String id;
    private String name;

    public PetCategory(String name) {
        this.name = name;
    }
}
