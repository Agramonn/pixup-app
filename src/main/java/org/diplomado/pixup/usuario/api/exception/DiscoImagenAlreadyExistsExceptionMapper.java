package org.diplomado.pixup.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.diplomado.pixup.usuario.api.dto.ErrorResponse;
import org.diplomado.pixup.usuario.domain.ex.DiscoImagenAlreadyExistsException;

@Provider
public class DiscoImagenAlreadyExistsExceptionMapper implements ExceptionMapper<DiscoImagenAlreadyExistsException> {
    @Override
    public Response toResponse(DiscoImagenAlreadyExistsException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(new ErrorResponse(
                        Response.Status.CONFLICT.getStatusCode(),
                        "BUSINESS_RULE",
                        e.getMessage()))
                .build();
    }
}
