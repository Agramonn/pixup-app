package org.diplomado.pixup.usuario.api.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.diplomado.pixup.usuario.api.UsuarioApi;
import org.diplomado.pixup.usuario.api.dto.RegistroUsuarioDTO;
import org.diplomado.pixup.usuario.api.dto.UsuarioResponseDTO;
import org.diplomado.pixup.usuario.api.dto.mapper.RegistroUsuarioMapper;
import org.diplomado.pixup.usuario.domain.Domicilio;
import org.diplomado.pixup.usuario.domain.Usuario;
import org.diplomado.pixup.usuario.service.UsuarioService;

public class UsuarioResource implements UsuarioApi {

    @Inject
    private UsuarioService usuarioService;

    @Inject
    RegistroUsuarioMapper registroUsuarioMapper;

    @Override
    public Response registrosUsuarios(RegistroUsuarioDTO registroUsuarioDTO) {
        // Transformacion DTO - Entity
        Usuario usuario = registroUsuarioMapper.toUsuario(registroUsuarioDTO.getUsuario());
        Domicilio domicilio = registroUsuarioMapper.toDomicilio(registroUsuarioDTO.getDomicilio());

        // Invocacion servicio negocio
        Usuario usuarioCreado = usuarioService.registrarUsuario(usuario,domicilio);

        // Transformacion Entity - DTO
        UsuarioResponseDTO usuarioResponseDTO = registroUsuarioMapper.toDto(usuarioCreado);

        return Response
                .status(Response.Status.CREATED)
                .entity(usuarioResponseDTO)
                .build();
    }
}
