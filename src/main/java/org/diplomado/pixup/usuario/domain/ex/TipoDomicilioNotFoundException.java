package org.diplomado.pixup.usuario.domain.ex;

public class TipoDomicilioNotFoundException extends RuntimeException{
    public TipoDomicilioNotFoundException(Integer id){
        super("No se encontro el tipo domicilio con el id: "+id);
    }
}
