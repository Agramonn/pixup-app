package org.diplomado.pixup.usuario.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscoRequestDTO {
    @NotBlank(message = "Titulo es requerido")
    private String titulo;
    @PositiveOrZero(message = "Precio deberia ser igual o mayor de cero")
    private Float precio;
    @PositiveOrZero(message = "Existencia deberia ser igual o mayor de cero")
    private Integer existencia;
    @PositiveOrZero(message = "Descuento deberia ser igual o mayor de cero")
    private Float descuento;
    private Date fechaLanzamiento;
    private String imagen;
    @NotNull(message = "Artista requerido")
    private Integer artista;
    @NotNull(message = "Disquera requerida")
    private Integer disquera;
    @NotNull(message = "Genero Musical requerido")
    private Integer generoMusical;
}
