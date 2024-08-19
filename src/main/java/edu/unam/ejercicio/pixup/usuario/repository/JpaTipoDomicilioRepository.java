package edu.unam.ejercicio.pixup.usuario.repository;

import edu.unam.ejercicio.pixup.usuario.domain.TipoDomicilio;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Singleton
public class JpaTipoDomicilioRepository  implements TipoDomicilioRepository{

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Collection<TipoDomicilio> findAll() {
        TypedQuery<TipoDomicilio> query = entityManager.createQuery("SELECT td TipoDomicilio td", TipoDomicilio.class);
        return query.getResultList();
    }

    @Override
    public Optional<TipoDomicilio> findById(Integer id) {
        TipoDomicilio tipoDomicilio = entityManager.find(TipoDomicilio.class, id);
        return tipoDomicilio!=null ? Optional.of(tipoDomicilio) : Optional.empty();
    }
}
