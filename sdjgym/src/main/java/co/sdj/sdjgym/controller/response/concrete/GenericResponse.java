package co.sdj.sdjgym.controller.response.concrete;

import java.util.List;

import co.sdj.sdjgym.controller.response.Response;

public final class GenericResponse extends Response {
	
	public static final Response build(final List<String> messages) {
		var response = new GenericResponse();
		response.setMessages(messages);
		return response;
	}
	
}
