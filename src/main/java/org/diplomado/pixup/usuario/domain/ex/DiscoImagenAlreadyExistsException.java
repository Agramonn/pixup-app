package org.diplomado.pixup.usuario.domain.ex;

public class DiscoImagenAlreadyExistsException extends RuntimeException{
    public DiscoImagenAlreadyExistsException(String imagen){
        super("Imagen del disco a guardar ya existente: "+imagen);
    }
}
