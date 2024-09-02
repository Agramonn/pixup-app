package org.diplomado.pixup.usuario.service;

import jakarta.ejb.Local;
import org.diplomado.pixup.usuario.domain.Colonia;

@Local
public interface ColoniaService {

    Colonia obtenerColoniaPorId(Integer id);
    Colonia crearColonia(Colonia colonia);
    void eliminarColoniaPorId(Integer id);
}
