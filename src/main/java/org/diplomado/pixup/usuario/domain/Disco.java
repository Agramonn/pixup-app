package org.diplomado.pixup.usuario.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Disco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Titulo es requerido")
    private String titulo;
    @PositiveOrZero(message = "Precio tiene que ser positivo o cero")
    private Float precio;
    @PositiveOrZero(message = "Existencia tiene que ser positivo o cero")
    private Integer existencia;
    @PositiveOrZero(message = "Descuento tiene que ser positivo o cero")
    private Float descuento;
    @Column(name = "fecha_lanzamiento")
    private Date fechaLanzamiento;
    private String imagen;
    @ManyToOne(targetEntity = Disquera.class)
    @JoinColumn(name = "id_disquera", nullable = false)
    private Disquera disquera;
    @ManyToOne(targetEntity = Artista.class)
    @JoinColumn(name = "id_artista", nullable = false)
    @NotNull(message = "Disco debe estar asociado a un artista")
    private Artista artista;
    @ManyToOne(targetEntity = GeneroMusical.class)
    @JoinColumn(name = "id_genero_musical", nullable = false)
    private GeneroMusical generoMusical;

    public Disco(String titulo, Float precio, Integer existencia, Float descuento, Date fechaLanzamiento, String imagen, Integer idArtista, Integer idDisquera, Integer idGeneroMusica){
        this.titulo=titulo;
        this.precio=precio;
        this.existencia=existencia;
        this.descuento=descuento;
        this.fechaLanzamiento=fechaLanzamiento;
        this.imagen=imagen;
        this.artista = new Artista();
        this.artista.setId(idArtista);
        this.disquera = new Disquera();
        this.disquera.setId(idDisquera);
        this.generoMusical= new GeneroMusical();
        this.generoMusical.setId(idGeneroMusica);
    }
}
