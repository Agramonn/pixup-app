package org.diplomado.pixup.usuario.respository;

import org.diplomado.pixup.usuario.domain.Disquera;

import java.util.Optional;

public interface DisqueraRepository {
    Optional<Disquera> findById(Integer id);
}
