package co.sdj.sdjgym.controller.response.concrete;

import java.util.List;

import co.sdj.sdjgym.controller.response.Response;
import co.sdj.sdjgym.controller.response.ResponseWithData;
import co.sdj.sdjgym.dto.IdentificationTypeDTO;

public class IdentificationTypeResponse extends ResponseWithData<IdentificationTypeDTO> {
	
	public static final Response build(final List<String> messages, final List<IdentificationTypeDTO> data) {
		var response = new IdentificationTypeResponse();
		response.setMessages(messages);
		response.setData(data);
		
		return response;
	}
	
}
