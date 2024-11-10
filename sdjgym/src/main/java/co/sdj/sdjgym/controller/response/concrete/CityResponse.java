package co.sdj.sdjgym.controller.response.concrete;

import java.util.List;

import co.sdj.sdjgym.controller.response.Response;
import co.sdj.sdjgym.controller.response.ResponseWithData;
import co.sdj.sdjgym.dto.basedata.CityDTO;

public final class CityResponse extends ResponseWithData<CityDTO> {
	
	public static final Response build(final List<String> messages, final List<CityDTO> data) {
		var response = new CityResponse();
		response.setMessages(messages);
		response.setData(data);
		
		return response;
	}
}
