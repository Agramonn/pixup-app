package org.diplomado.pixup.usuario.domain.ex;

public class DisqueraNotFoundException extends RuntimeException{
    public DisqueraNotFoundException(Integer id){
        super("Disquera no encontrada con ID: "+id);
    }
}
