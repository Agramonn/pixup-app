package org.diplomado.pixup.usuario.domain.ex;

public class ColoniaAlreadyExistsException extends RuntimeException {
    public ColoniaAlreadyExistsException(String cp, String nombre) {
        super("Ya existe la Colonia con cp: "+cp+" y nombre: "+nombre);
    }
}
