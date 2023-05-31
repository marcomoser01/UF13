package it.altaformazione.foodmemongo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ProductDTO {
    
    private String id;

    private String name;

    private String description;

    private float price;

    private Byte immage;

}
