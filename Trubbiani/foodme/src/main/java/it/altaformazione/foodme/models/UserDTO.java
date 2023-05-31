package it.altaformazione.foodme.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDTO {

    @NotBlank
    @NotEmpty
    private Long id;

    private String name;

    private String email;

    private String mobile;

    private String gender;
}
