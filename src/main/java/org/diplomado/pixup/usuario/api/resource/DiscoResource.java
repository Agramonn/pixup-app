package org.diplomado.pixup.usuario.api.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.diplomado.pixup.usuario.api.DiscoApi;
import org.diplomado.pixup.usuario.api.dto.DiscoRequestDTO;
import org.diplomado.pixup.usuario.api.dto.DiscoResponseDTO;
import org.diplomado.pixup.usuario.api.dto.mapper.DiscoMapper;
import org.diplomado.pixup.usuario.domain.Disco;
import org.diplomado.pixup.usuario.domain.ex.DiscoAlreadyExistsException;
import org.diplomado.pixup.usuario.service.DiscoService;

public class DiscoResource implements DiscoApi {

    @Inject
    private DiscoService discoService;

    @Inject
    DiscoMapper discoMapper;

    @Override
    public Response altaDisco(DiscoRequestDTO discoRequestDTO) {
        //Transformacion DTO - Entity
        Disco disco = discoMapper.toDisco(discoRequestDTO);
        //Invocacion servicio de negocio
        Disco discoCreado = discoService.registrarDisco(disco);
        //Transformacion Entity - DTO
        DiscoResponseDTO discoResponseDTO = discoMapper.toDto(discoCreado);

        return Response
                .status(Response.Status.CREATED)
                .entity(discoResponseDTO)
                .build();
    }
}
