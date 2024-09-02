package org.diplomado.pixup.usuario.respository.impl;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.diplomado.pixup.usuario.domain.Colonia;
import org.diplomado.pixup.usuario.respository.ColoniaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Singleton
public class JpaColoniaRepository implements ColoniaRepository {

    @PersistenceContext(name = "pixup")
    private EntityManager entityManager;

    @Override
    public Collection<Colonia> findByCp(String cp) {
        TypedQuery<Colonia> query = entityManager.createQuery("SELECT c FROM Colonia c WHERE c.cp = :cp", Colonia.class);
        query.setParameter("cp", cp);
        return query.getResultList();
    }

    @Override
    public Optional<Colonia> findById(Integer id) {
        Colonia colonia = entityManager.find(Colonia.class, id);
        return colonia != null ? Optional.of(colonia) : Optional.empty();
    }

    @Override
    public Colonia saveOrUpdate(Colonia colonia) {
        entityManager.persist(colonia);
        return colonia;
    }

    @Override
    public void delete(Colonia colonia) {
        entityManager.remove(colonia);
    }

    @Override
    public Optional<Colonia> findByCpAndNombre(String cp, String nombre) {
        TypedQuery<Colonia> query = entityManager.createQuery("SELECT c FROM Colonia c WHERE c.cp = :cp AND c.nombre = :nombre", Colonia.class);
        query.setParameter("cp", cp);
        query.setParameter("nombre", nombre);
        List<Colonia> colonias = query.getResultList();
        return !colonias.isEmpty() ? Optional.of(colonias.get(0)) : Optional.empty();
    }
}
