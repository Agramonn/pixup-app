package org.diplomado.pixup.usuario.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tipo_domicilio") //Esta anotacion solo tiene que hacer uso cuando la tabla tiene distinto nombre que la clase
public class TipoDomicilio implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
}
