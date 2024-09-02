package org.diplomado.pixup.usuario.respository;

import org.diplomado.pixup.usuario.domain.GeneroMusical;

import java.util.Optional;

public interface GeneroMusicalRepository {
    Optional<GeneroMusical> findById(Integer id);
}
