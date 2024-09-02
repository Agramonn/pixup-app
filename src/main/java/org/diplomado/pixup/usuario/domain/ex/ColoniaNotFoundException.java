package org.diplomado.pixup.usuario.domain.ex;

public class ColoniaNotFoundException extends RuntimeException {
    public ColoniaNotFoundException(Integer id) {
        super("No se encontro la colonia con id: " + id);
    }
}
