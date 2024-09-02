package org.diplomado.pixup.usuario.domain.ex;

public class ArtistaNotFoundException extends RuntimeException{
    public ArtistaNotFoundException(Integer id){
        super("Artista no encontrado con ID: "+id);
    }
}
