package org.diplomado.pixup.usuario.respository.impl;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.diplomado.pixup.usuario.domain.Disquera;
import org.diplomado.pixup.usuario.respository.DisqueraRepository;

import java.util.Optional;

@Singleton
public class JpaDisqueraRepository implements DisqueraRepository {

    @PersistenceContext(name = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Disquera> findById(Integer id) {
        Disquera disquera = entityManager.find(Disquera.class, id);
        return disquera != null ? Optional.of(disquera) : Optional.empty();
    }
}
