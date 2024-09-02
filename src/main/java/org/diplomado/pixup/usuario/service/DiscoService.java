package org.diplomado.pixup.usuario.service;

import jakarta.ejb.Local;
import org.diplomado.pixup.usuario.domain.Disco;

@Local
public interface DiscoService {

    Disco registrarDisco(Disco disco);

}
