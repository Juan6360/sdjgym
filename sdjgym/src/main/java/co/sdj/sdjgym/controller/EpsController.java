package co.sdj.sdjgym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sdj.crosscutting.exceptions.SdjApplicationException;
import co.sdj.sdjgym.businesslogic.facade.eps.impl.FindEpsFacadeImpl;
import co.sdj.sdjgym.controller.response.GenerateResponse;
import co.sdj.sdjgym.controller.response.concrete.EpsResponse;
import co.sdj.sdjgym.dto.EpsDTO;

@RestController
@RequestMapping("/api/v1/eps")
public final class EpsController {
	
	@GetMapping
	public ResponseEntity<EpsResponse> retrieveAll() {
		var messages = new ArrayList<String>();
		List<EpsDTO> list = new ArrayList<>();
		
		try {
			var findEpsFacade = new FindEpsFacadeImpl();
			list = findEpsFacade.execute(EpsDTO.create());
			
			messages.add("Las Eps se consultaron de forma satisfactoria");
		} catch (final SdjApplicationException exception) {
			messages.add(exception.getMessage());
			exception.printStackTrace();
		} catch (final Exception exception) {
			messages.add("Se ha presentado un problema inesperado al consultar las Eps");
			exception.printStackTrace();
		}
		
		EpsResponse responseWithData = new EpsResponse();
		
		responseWithData.setData(list);
		responseWithData.setMessages(messages);
		
		return ((new GenerateResponse<EpsResponse>()).generateSuccessResponseWithData(responseWithData));
	}
	
}
