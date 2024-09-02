package org.diplomado.pixup.usuario.respository.impl;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.diplomado.pixup.usuario.domain.Domicilio;
import org.diplomado.pixup.usuario.respository.DomicilioRepository;

@Singleton
public class JpaDomicilioRepository implements DomicilioRepository {

    @PersistenceContext(name = "pixup")
    private EntityManager entityManager;

    @Override
    public Domicilio save(Domicilio domicilio) {
        entityManager.persist(domicilio);
        return domicilio;
    }
}
