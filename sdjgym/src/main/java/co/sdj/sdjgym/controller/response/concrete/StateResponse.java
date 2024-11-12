package co.sdj.sdjgym.controller.response.concrete;

import java.util.List;

import co.sdj.sdjgym.controller.response.Response;
import co.sdj.sdjgym.controller.response.ResponseWithData;
import co.sdj.sdjgym.dto.StateDTO;

public final class StateResponse extends ResponseWithData<StateDTO> {
	
	public static final Response build(final List<String> messages, final List<StateDTO> data) {
		var response = new StateResponse();
		response.setMessages(messages);
		response.setData(data);
		
		return response;
	}
}
