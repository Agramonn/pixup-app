package org.diplomado.pixup.usuario.domain.ex;

public class GeneroMusicalNotFoundException extends RuntimeException{
    public GeneroMusicalNotFoundException(Integer id){
        super("Genero musical no econtrado con ID: "+id);
    }
}
