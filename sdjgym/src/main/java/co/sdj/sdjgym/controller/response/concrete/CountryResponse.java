package co.sdj.sdjgym.controller.response.concrete;

import java.util.List;

import co.sdj.sdjgym.controller.response.Response;
import co.sdj.sdjgym.controller.response.ResponseWithData;
import co.sdj.sdjgym.dto.CountryDTO;

public class CountryResponse extends ResponseWithData<CountryDTO> {
	
	public static final Response build(final List<String> messages, final List<CountryDTO> data) {
		var response = new CountryResponse();
		response.setMessages(messages);
		response.setData(data);
		
		return response;
	}

}
