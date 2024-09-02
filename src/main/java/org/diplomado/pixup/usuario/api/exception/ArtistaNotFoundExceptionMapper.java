package org.diplomado.pixup.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.diplomado.pixup.usuario.api.dto.ErrorResponse;
import org.diplomado.pixup.usuario.domain.ex.ArtistaNotFoundException;

@Provider
public class ArtistaNotFoundExceptionMapper implements ExceptionMapper<ArtistaNotFoundException> {
    @Override
    public Response toResponse(ArtistaNotFoundException e) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponse(
                        Response.Status.CONFLICT.getStatusCode(),
                        "BUSINESS_RULE",
                        e.getMessage()))
                .build();
    }
}
