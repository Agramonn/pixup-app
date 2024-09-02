package org.diplomado.pixup.usuario.respository.impl;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.diplomado.pixup.usuario.domain.Artista;
import org.diplomado.pixup.usuario.respository.ArtistaRepository;

import java.util.Optional;

@Singleton
public class JpaArtistaReposiroy implements ArtistaRepository {

    @PersistenceContext(name = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Artista> findById(Integer id) {
        Artista artista = entityManager.find(Artista.class, id);
        return artista!=null ? Optional.of(artista) : Optional.empty();
    }
}
