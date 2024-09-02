package org.diplomado.pixup.usuario.service;

import jakarta.ejb.Local;
import org.diplomado.pixup.usuario.domain.Domicilio;
import org.diplomado.pixup.usuario.domain.Usuario;

@Local
public interface UsuarioService {

    Usuario registrarUsuario(Usuario usuario, Domicilio domicilio);

}
