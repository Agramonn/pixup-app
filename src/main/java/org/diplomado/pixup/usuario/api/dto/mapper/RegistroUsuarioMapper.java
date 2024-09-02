package org.diplomado.pixup.usuario.api.dto.mapper;

import jakarta.inject.Singleton;
import org.diplomado.pixup.usuario.api.dto.DomicilioDTO;
import org.diplomado.pixup.usuario.api.dto.UsuarioRequestDTO;
import org.diplomado.pixup.usuario.api.dto.UsuarioResponseDTO;
import org.diplomado.pixup.usuario.domain.Domicilio;
import org.diplomado.pixup.usuario.domain.Usuario;

@Singleton
public class RegistroUsuarioMapper {

    public UsuarioResponseDTO toDto(Usuario usuario){
        return new UsuarioResponseDTO(usuario.getId(), usuario.getEmail());
    }

   public Usuario toUsuario(UsuarioRequestDTO usuarioRequestDTO){
        return new Usuario(null,usuarioRequestDTO.getNombre(),usuarioRequestDTO.getPrimerApellido(),usuarioRequestDTO.getSegundoApellido(),usuarioRequestDTO.getPassword(),usuarioRequestDTO.getEmail(),usuarioRequestDTO.getRfc());
   }

   public Domicilio toDomicilio(DomicilioDTO domicilioDTO){
        return new Domicilio(domicilioDTO.getCalle(), domicilioDTO.getNumExterior(), domicilioDTO.getNumInterior(),domicilioDTO.getColonia(),domicilioDTO.getTipoDomicilio());
   }

}
