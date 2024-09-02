package org.diplomado.pixup.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.diplomado.pixup.usuario.api.dto.ErrorResponse;
import org.diplomado.pixup.usuario.domain.ex.GeneroMusicalNotFoundException;

@Provider
public class GeneroMusicalNotFoundExceptionMapper implements ExceptionMapper<GeneroMusicalNotFoundException>{
    @Override
    public Response toResponse(GeneroMusicalNotFoundException e) {
        return Response
                .status(Response.Status.PRECONDITION_REQUIRED)
                .entity(new ErrorResponse(
                        Response.Status.PRECONDITION_REQUIRED.getStatusCode(),
                        "BUSINESS_RULE",
                        e.getMessage()))
                .build();
    }
}
