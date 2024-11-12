package co.sdj.sdjgym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sdj.crosscutting.exceptions.SdjApplicationException;
import co.sdj.sdjgym.businesslogic.facade.eps.impl.FindEpsFacadeImpl;
import co.sdj.sdjgym.businesslogic.facade.identificationType.impl.FindIdentificationTypeFacadeImpl;
import co.sdj.sdjgym.controller.response.GenerateResponse;
import co.sdj.sdjgym.controller.response.concrete.EpsResponse;
import co.sdj.sdjgym.controller.response.concrete.IdentificationTypeResponse;
import co.sdj.sdjgym.dto.EpsDTO;
import co.sdj.sdjgym.dto.IdentificationTypeDTO;

@RestController
@RequestMapping("/api/v1/identificationtypes")
public final class IdentificationTypeController {
	
	@GetMapping
	public ResponseEntity<IdentificationTypeResponse> retrieveAll() {
		var messages = new ArrayList<String>();
		List<IdentificationTypeDTO> list = new ArrayList<>();
		
		try {
			var findIdentificationType = new FindIdentificationTypeFacadeImpl();
			list = findIdentificationType.execute(IdentificationTypeDTO.create());
			
			messages.add("Los tipos de identificación se consultaron de forma satisfactoria");
		} catch (final SdjApplicationException exception) {
			messages.add(exception.getMessage());
			exception.printStackTrace();
		} catch (final Exception exception) {
			messages.add("Se ha presentado un problema inesperado al consultar los tipos de identificación");
			exception.printStackTrace();
		}
		
		IdentificationTypeResponse responseWithData = new IdentificationTypeResponse();
		
		responseWithData.setData(list);
		responseWithData.setMessages(messages);
		
		return ((new GenerateResponse<IdentificationTypeResponse>()).generateSuccessResponseWithData(responseWithData));
	}

}
