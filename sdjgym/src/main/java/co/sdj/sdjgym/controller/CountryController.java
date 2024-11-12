package co.sdj.sdjgym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sdj.crosscutting.exceptions.SdjApplicationException;
import co.sdj.sdjgym.businesslogic.facade.country.impl.FindCountryFacadeImpl;
import co.sdj.sdjgym.controller.response.GenerateResponse;
import co.sdj.sdjgym.controller.response.concrete.CountryResponse;
import co.sdj.sdjgym.dto.CountryDTO;

@RestController
@RequestMapping("/api/v1/countries")
public final class CountryController {

	@GetMapping
	public ResponseEntity<CountryResponse> retrieveAll() {
		var messages = new ArrayList<String>();
		List<CountryDTO> list = new ArrayList<>();
		
		try {
			var findCountryFacade = new FindCountryFacadeImpl();
			list = findCountryFacade.execute(CountryDTO.create());
			
			messages.add("Los paises se consultaron de forma satisfactoria");
		} catch (final SdjApplicationException exception) {
			messages.add(exception.getMessage());
			exception.printStackTrace();
		} catch (final Exception exception) {
			messages.add("Se ha presentado un problema inesperado al consultar los paises");
			exception.printStackTrace();
		}
		
		CountryResponse responseWithData = new CountryResponse();
		
		responseWithData.setData(list);
		responseWithData.setMessages(messages);
		
		return ((new GenerateResponse<CountryResponse>()).generateSuccessResponseWithData(responseWithData));
	}
	
}
