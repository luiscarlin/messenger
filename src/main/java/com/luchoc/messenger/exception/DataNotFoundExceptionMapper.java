package com.luchoc.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.luchoc.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), Status.NOT_FOUND.getStatusCode(), "http://sorry-no-docs.com");
		
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}
}