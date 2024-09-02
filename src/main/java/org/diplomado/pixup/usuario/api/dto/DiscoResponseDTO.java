package org.diplomado.pixup.usuario.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscoResponseDTO {

    private Integer id;
    private String titulo;
    private String artista;
    private String disquera;
    private String genero;
}
