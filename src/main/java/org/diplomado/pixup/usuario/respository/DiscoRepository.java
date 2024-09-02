package org.diplomado.pixup.usuario.respository;

import org.diplomado.pixup.usuario.domain.Disco;

import java.util.Optional;

public interface DiscoRepository {
    Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista);
    Disco save(Disco disco);
    Optional<Disco> findByImagen(String imagen);
}
