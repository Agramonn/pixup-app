package org.diplomado.pixup.usuario.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String calle;
    @Column(name = "num_exterior")
    private String numExterior;
    @Column(name = "num_interior")
    private String numInterior;
    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne(targetEntity = Colonia.class)
    @JoinColumn(name = "id_colonia")
    private Colonia colonia;
    @ManyToOne(targetEntity = TipoDomicilio.class)
    @JoinColumn(name = "id_tipo_domicilio")
    private TipoDomicilio tipoDomicilio;

    public Domicilio(String calle, String numExterior, String numInterior, Integer idColonia, Integer idTipoDomicilio){
        this.calle = calle;
        this.numExterior=numExterior;
        this.numInterior=numInterior;
        this.colonia = new Colonia();
        this.colonia.setId(idColonia);
        this.tipoDomicilio = new TipoDomicilio();
        this.tipoDomicilio.setId(idTipoDomicilio);
    }
}
