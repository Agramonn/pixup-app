package org.diplomado.pixup.usuario.api.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.diplomado.pixup.usuario.api.ColoniaApi;
import org.diplomado.pixup.usuario.api.dto.ColoniaDTO;
import org.diplomado.pixup.usuario.api.dto.mapper.ColoniaMapper;
import org.diplomado.pixup.usuario.domain.Colonia;
import org.diplomado.pixup.usuario.domain.ex.ColoniaAlreadyExistsException;
import org.diplomado.pixup.usuario.respository.ColoniaRepository;
import org.diplomado.pixup.usuario.service.ColoniaService;

import java.util.Collection;
import java.util.List;

public class ColoniaResource implements ColoniaApi {

    @Inject
    private ColoniaRepository coloniaRepository;

    @Inject
    private ColoniaService coloniaService;

    @Inject
    private ColoniaMapper coloniaMapper;

    @Override
    public Colonia getColoniaById(Integer id) {
        return coloniaService.obtenerColoniaPorId(id);
    }

    @Override
    public Collection<ColoniaDTO> getColoniasByCp(String cp) {
        return coloniaRepository.findByCp(cp)
                .stream().map(colonia -> coloniaMapper.toDto(colonia))
                .toList();
    }

    @Override
    public void deleteColonia(Integer id) {
        coloniaService.eliminarColoniaPorId(id);
    }

    @Override
    public Response createColonia(Colonia colonia) {
        Colonia coloniaCreada = coloniaService.crearColonia(colonia);
        return Response.status(Response.Status.CREATED).entity(colonia).build();
    }
}
