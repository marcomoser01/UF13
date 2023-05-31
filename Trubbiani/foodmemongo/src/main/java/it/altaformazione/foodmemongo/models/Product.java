package it.altaformazione.foodmemongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

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
// Le annotation @table e @Entity se uso mongo non servono
@Document(collection = "products") //In mongo è obbligartoria
public class Product {
    
    @Id
    private String id;

    @NonNull
    private String name;

    private String description;

    @NonNull
    private float price;

    private Byte immage;



    //TODO implementare un converter to ProductsDTO e quindi cambiare il metodo in ProductService
}
