package org.diplomado.pixup.usuario.respository;

import org.diplomado.pixup.usuario.domain.TipoDomicilio;

import java.util.Collection;
import java.util.Optional;

public interface TipoDomicilioRepository {

    Collection<TipoDomicilio> findAll();
    Optional<TipoDomicilio> findById(Integer id);

}
