package org.diplomado.pixup.usuario.respository.impl;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.diplomado.pixup.usuario.domain.TipoDomicilio;
import org.diplomado.pixup.usuario.respository.TipoDomicilioRepository;

import java.util.Collection;
import java.util.Optional;

@Singleton
public class JpaTipoDomicilioRepository implements TipoDomicilioRepository {

    @PersistenceContext(name = "pixup")
    private EntityManager entityManager;

    @Override
    public Collection<TipoDomicilio> findAll() {
        TypedQuery<TipoDomicilio> query = entityManager.createQuery("SELECT t FROM TipoDomicilio t", TipoDomicilio.class);
        return query.getResultList();
    }

    @Override
    public Optional<TipoDomicilio> findById(Integer id) {
        TipoDomicilio tipoDomicilio = entityManager.find(TipoDomicilio.class, id);
        return tipoDomicilio != null ? Optional.of(tipoDomicilio) : Optional.empty();
    }
}
