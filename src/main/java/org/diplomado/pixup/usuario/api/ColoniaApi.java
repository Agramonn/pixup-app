package org.diplomado.pixup.usuario.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.diplomado.pixup.usuario.api.dto.ColoniaDTO;
import org.diplomado.pixup.usuario.domain.Colonia;

import java.util.Collection;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("colonias")
public interface ColoniaApi {

    @GET
    @Path("{id}")
    Colonia getColoniaById(@PathParam("id") Integer id);

    @GET
    Collection<ColoniaDTO> getColoniasByCp(@NotBlank @QueryParam("cp") String cp);

    @DELETE
    @Path("{id}")
    void deleteColonia(@PathParam("id") Integer id);

    @POST
    Response createColonia(@NotNull @Valid Colonia colonia);

}
