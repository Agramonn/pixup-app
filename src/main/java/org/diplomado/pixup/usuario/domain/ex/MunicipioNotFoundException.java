package org.diplomado.pixup.usuario.domain.ex;

public class MunicipioNotFoundException extends RuntimeException {
    public MunicipioNotFoundException(Integer id) {
        super("No se encontro el municipio con el id: "+id);
    }
}
