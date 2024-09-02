package org.diplomado.pixup.usuario.respository.impl;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.diplomado.pixup.usuario.domain.GeneroMusical;
import org.diplomado.pixup.usuario.respository.GeneroMusicalRepository;

import java.util.Optional;

@Singleton
public class JpaGeneroMusicalRepository implements GeneroMusicalRepository {

    @PersistenceContext(name = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<GeneroMusical> findById(Integer id) {
        GeneroMusical generoMusical = entityManager.find(GeneroMusical.class, id);
        return generoMusical != null ? Optional.of(generoMusical) : Optional.empty();
    }
}
