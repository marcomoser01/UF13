package it.altaformazione.foodmemongo.models.dtos;

import java.util.ArrayList;
import java.util.List;

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
public class UserDTO {
    private String id;

    private String name;

    private String email;

    private String mobile;

    private String gender;

    private int age;

    @Builder.Default //Così serve per poter far ritornare una stringa vuota nel caso in cui sia vuota
    List<String> orders = new ArrayList<>();
}
