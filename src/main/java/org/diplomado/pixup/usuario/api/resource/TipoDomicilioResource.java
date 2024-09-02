package org.diplomado.pixup.usuario.api.resource;

import jakarta.inject.Inject;
import org.diplomado.pixup.usuario.api.TipoDomicilioApi;
import org.diplomado.pixup.usuario.domain.TipoDomicilio;
import org.diplomado.pixup.usuario.respository.TipoDomicilioRepository;

import java.util.Collection;
import java.util.List;

public class TipoDomicilioResource implements TipoDomicilioApi {

    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository;

    @Override
    public Collection<TipoDomicilio> getAll() {
        return tipoDomicilioRepository.findAll();
    }
}
