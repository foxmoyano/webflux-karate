package cl.foxcorp.app.webfluxkarate.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InUserDto {
    private String id;
    @NotNull
    @Size(max = 50, min = 1)
    private String username;
    @NotNull
    @Email(message = "El atributo debe ser una dirección de correo electrónico válida.")
    private String email;
    @NotNull
    private Boolean state;
}