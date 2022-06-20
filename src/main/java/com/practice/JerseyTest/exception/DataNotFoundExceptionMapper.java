package com.practice.JerseyTest.exception;

import com.practice.JerseyTest.model.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ExceptionMapper;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>
{
    public Response toResponse(final DataNotFoundException ex) {
        final ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404);
        return Response.status(Response.Status.NOT_FOUND).entity((Object)errorMessage).build();
    }
}