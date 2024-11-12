package co.sdj.sdjgym.controller.response.concrete;

import java.util.List;

import co.sdj.sdjgym.controller.response.Response;
import co.sdj.sdjgym.controller.response.ResponseWithData;
import co.sdj.sdjgym.dto.EpsDTO;

public final class EpsResponse extends ResponseWithData<EpsDTO> {
	
	public static final Response build(final List<String> messages, final List<EpsDTO> data) {
		var response = new EpsResponse();
		response.setMessages(messages);
		response.setData(data);
		
		return response;
	}
}
