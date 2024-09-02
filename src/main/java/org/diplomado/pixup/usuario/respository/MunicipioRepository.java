package org.diplomado.pixup.usuario.respository;

import org.diplomado.pixup.usuario.domain.Municipio;

import java.util.Optional;

public interface MunicipioRepository {
    Optional<Municipio> findById(Integer id);
}
