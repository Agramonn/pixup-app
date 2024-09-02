package org.diplomado.pixup.usuario.respository.impl;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.diplomado.pixup.usuario.domain.Municipio;
import org.diplomado.pixup.usuario.respository.MunicipioRepository;

import java.util.Optional;

@Singleton
public class JpaMunicipioRepository implements MunicipioRepository {

    @PersistenceContext(name = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Municipio> findById(Integer id) {
        Municipio municipio = entityManager.find(Municipio.class, id);
        return municipio != null ? Optional.of(municipio) : Optional.empty();
    }
}
