package co.sdj.sdjgym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sdj.crosscutting.exceptions.SdjApplicationException;
import co.sdj.sdjgym.businesslogic.facade.state.impl.FindStateFacadeImpl;
import co.sdj.sdjgym.controller.response.GenerateResponse;
import co.sdj.sdjgym.controller.response.concrete.StateResponse;
import co.sdj.sdjgym.dto.StateDTO;

@RestController
@RequestMapping("/api/v1/states")
public class StateController {

	@GetMapping
	public ResponseEntity<StateResponse> retrieveAll() {
		var messages = new ArrayList<String>();
		List<StateDTO> list = new ArrayList<>();
		
		try {
			var findStateFacade = new FindStateFacadeImpl();
			list = findStateFacade.execute(StateDTO.create());
			
			messages.add("Las Eps se consultaron de forma satisfactoria");
		} catch (final SdjApplicationException exception) {
			messages.add(exception.getMessage());
			exception.printStackTrace();
		} catch (final Exception exception) {
			messages.add("Se ha presentado un problema inesperado al consultar las Eps");
			exception.printStackTrace();
		}
		
		StateResponse responseWithData = new StateResponse();
		
		responseWithData.setData(list);
		responseWithData.setMessages(messages);
		
		return ((new GenerateResponse<StateResponse>()).generateSuccessResponseWithData(responseWithData));
	}
	
}
