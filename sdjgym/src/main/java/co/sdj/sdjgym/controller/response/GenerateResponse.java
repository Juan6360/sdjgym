package co.sdj.sdjgym.controller.response;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.sdj.sdjgym.controller.response.concrete.GenericResponse;

public final class GenerateResponse<T> {
	
	public static ResponseEntity<GenericResponse> generateSuccessResponse(final List<String> messages) {
		var genericResponse = new GenericResponse();
		genericResponse.setMessages(messages);
		
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}
	
	public static ResponseEntity<GenericResponse> generateFailedResponse(final List<String> messages) {
		var genericResponse = new GenericResponse();
		genericResponse.setMessages(messages);
		
		return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<T> generateSuccessResponseWithData(final T responseWithData) {
		
		return new ResponseEntity<>(responseWithData, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> generateFailedResponseWithData(final Object responseWithData) {
		
		return new ResponseEntity<>(responseWithData, HttpStatus.BAD_REQUEST);
	}
	
}
