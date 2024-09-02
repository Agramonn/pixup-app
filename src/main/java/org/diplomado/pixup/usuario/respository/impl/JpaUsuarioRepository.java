package org.diplomado.pixup.usuario.respository.impl;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.diplomado.pixup.usuario.domain.Usuario;
import org.diplomado.pixup.usuario.respository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Singleton
public class JpaUsuarioRepository implements UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Usuario> findByEmail(String email) {
        TypedQuery<Usuario> query = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.email= :email", Usuario.class
        );
        query.setParameter("email", email);
        List<Usuario> usuarios = query.getResultList();
        return !usuarios.isEmpty() ? Optional.of(usuarios.get(0)) : Optional.empty();
    }

    @Override
    public Usuario save(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }
}
