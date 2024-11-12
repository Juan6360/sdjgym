package co.sdj.sdjgym.controller.response.concrete;

import java.util.List;

import co.sdj.sdjgym.controller.response.Response;
import co.sdj.sdjgym.controller.response.ResponseWithData;
import co.sdj.sdjgym.dto.UserDTO;

public class UserResponse extends ResponseWithData<UserDTO> {
	
	public static final Response build(final List<String> messages, final List<UserDTO> data) {
		var response = new UserResponse();
		response.setMessages(messages);
		response.setData(data);
		
		return response;
	}
}