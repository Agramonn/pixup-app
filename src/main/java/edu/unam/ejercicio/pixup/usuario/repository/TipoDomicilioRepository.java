package edu.unam.ejercicio.pixup.usuario.repository;

import edu.unam.ejercicio.pixup.usuario.domain.TipoDomicilio;

import java.util.Collection;
import java.util.Optional;

public interface TipoDomicilioRepository {

    Collection<TipoDomicilio> findAll();
    Optional<TipoDomicilio> findById(Integer id);

}
