package org.diplomado.pixup.usuario.respository;

import org.diplomado.pixup.usuario.domain.Artista;

import java.util.Optional;

public interface ArtistaRepository {
    Optional<Artista> findById(Integer id);
}
