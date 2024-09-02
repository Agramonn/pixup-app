package org.diplomado.pixup.usuario.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroUsuarioDTO {

    @NotNull(message = "Usuario es requierdo para realizar el registro del usuario")
    @Valid
    private UsuarioRequestDTO usuario;

    @NotNull(message = "Domicilio es requierdo para realizar el registro del usuario")
    @Valid
    private DomicilioDTO domicilio;

}
