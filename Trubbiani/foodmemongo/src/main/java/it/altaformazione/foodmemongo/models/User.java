package it.altaformazione.foodmemongo.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "users") //In mongo è obbligartoria
public class User {

    @Id //Basta solo ID perchè in mongo è automaticamente autogenerato
    private String id;

    private String name;

    private String email;

    private String mobile;

    private String gender;

    private int age;

    @Builder.Default
    List<String> orderIds = new ArrayList<>();

}
