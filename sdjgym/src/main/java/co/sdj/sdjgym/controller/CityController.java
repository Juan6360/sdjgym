package co.sdj.sdjgym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sdj.crosscutting.exceptions.SdjApplicationException;
import co.sdj.sdjgym.businesslogic.facade.city.impl.FindCityFacadeImpl;
import co.sdj.sdjgym.controller.response.GenerateResponse;
import co.sdj.sdjgym.controller.response.concrete.CityResponse;
import co.sdj.sdjgym.dto.CityDTO;

@RestController
@RequestMapping("/api/v1/cities")
public final class CityController {

	@GetMapping
	public ResponseEntity<CityResponse> retrieveAll() {
		var messages = new ArrayList<String>();
		List<CityDTO> list = new ArrayList<>();
		
		try {
			var findCityFacade = new FindCityFacadeImpl();
			list = findCityFacade.execute(CityDTO.create());
			
			messages.add("Las ciudades se consultaron de forma satisfactoria");
		} catch (final SdjApplicationException exception) {
			messages.add(exception.getMessage());
			exception.printStackTrace();
		} catch (final Exception exception) {
			messages.add("Se ha presentado un problema inesperado al consultar las ciudades");
			exception.printStackTrace();
		}
		
		CityResponse responseWithData = new CityResponse();
		
		responseWithData.setData(list);
		responseWithData.setMessages(messages);
		
		return ((new GenerateResponse<CityResponse>()).generateSuccessResponseWithData(responseWithData));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CityResponse> retrieveById(@PathVariable String id) {


		CityResponse responseWithData = new CityResponse();
		
		var messages = new ArrayList<String>();
		messages.add("La ciudad se consultaron de forma satisfactoria");
		
		var list = new ArrayList<CityDTO>();
		
		responseWithData.setData(list);
		responseWithData.setMessages(messages);
		
		return ((new GenerateResponse<CityResponse>()).generateSuccessResponseWithData(responseWithData));
	}
}
