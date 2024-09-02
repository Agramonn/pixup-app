package org.diplomado.pixup.usuario.domain.ex;

public class DiscoAlreadyExistsException extends RuntimeException{
    public DiscoAlreadyExistsException(String titulo, Integer idArtista){
        super("Disco ya existente con titulo: "+titulo+" y con ID de artista: "+idArtista);
    }
}
