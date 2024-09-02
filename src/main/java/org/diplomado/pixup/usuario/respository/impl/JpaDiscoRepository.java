package org.diplomado.pixup.usuario.respository.impl;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.diplomado.pixup.usuario.domain.Disco;
import org.diplomado.pixup.usuario.respository.DiscoRepository;

import java.util.List;
import java.util.Optional;

@Singleton
public class JpaDiscoRepository implements DiscoRepository {

    @PersistenceContext(name = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista){
        TypedQuery<Disco> query = entityManager.createQuery("SELECT d FROM Disco d WHERE d.titulo= :titulo AND d.artista.id= :idArtista", Disco.class);
        query.setParameter("titulo", titulo);
        query.setParameter("idArtista", idArtista);
        List<Disco> discos = query.getResultList();
        return !discos.isEmpty() ? Optional.of(discos.get(0)) : Optional.empty();
    }

    @Override
    public Disco save(Disco disco) {
        entityManager.persist(disco);
        return disco;
    }

    @Override
    public Optional<Disco> findByImagen(String imagen) {
        TypedQuery<Disco> query = entityManager.createQuery("SELECT d FROM Disco d WHERE d.imagen = :imagen", Disco.class);
        query.setParameter("imagen", imagen);
        List<Disco> discos = query.getResultList();
        return !discos.isEmpty() ?  Optional.of(discos.get(0)) : Optional.empty();
    }
}
