package co.sdj.sdjgym.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sdj.crosscutting.exceptions.SdjApplicationException;
import co.sdj.sdjgym.businesslogic.facade.user.impl.RegisterUserFacadeImpl;
import co.sdj.sdjgym.controller.response.GenerateResponse;
import co.sdj.sdjgym.controller.response.concrete.GenericResponse;
import co.sdj.sdjgym.controller.response.concrete.UserResponse;
import co.sdj.sdjgym.crosscutting.exceptions.SdjException;
import co.sdj.sdjgym.dto.UserDTO;


@RestController
@RequestMapping("/api/v1/users")
public final class UserController {

	@PostMapping
	public ResponseEntity<GenericResponse> create(@RequestBody UserDTO user) {
		var messages = new ArrayList<String>();

		try {
			var registerUserFacade = new RegisterUserFacadeImpl();
			registerUserFacade.execute(user);

			messages.add("La ciudad se registró de forma satisfactoria");

			return GenerateResponse.generateSuccessResponse(messages);
		} catch (final SdjException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();

			return GenerateResponse.generateFailedResponse(messages);
		} catch (final SdjApplicationException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();

			return GenerateResponse.generateFailedResponse(messages);
		} catch (final Exception exception) {
			messages.add(
					"Se ha presentado un problema inesperado tratando de llevar a cabo el registro de la ciudad de forma satisfactoria....");
			exception.printStackTrace();

			return GenerateResponse.generateFailedResponse(messages);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<GenericResponse> update(@PathVariable String id, @RequestBody UserDTO user) {
		var messages = new ArrayList<String>();
		messages.add("La ciudad se actualizó de forma satisfactoria");

		return GenerateResponse.generateSuccessResponse(messages);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<GenericResponse> delete(@PathVariable String id) {
		var messages = new ArrayList<String>();
		messages.add("La ciudad se eliminó de forma satisfactoria");

		return GenerateResponse.generateSuccessResponse(messages);

	}

	@GetMapping
	public ResponseEntity<UserResponse> retrieveAll() {

		
		UserResponse responseWithData = new UserResponse();
		var messages = new ArrayList<String>();
		messages.add("Las ciudades se consultaron de forma satisfactoria");

		var list = new ArrayList<UserDTO>();

		responseWithData.setData(list);
		responseWithData.setMessages(messages);

		return ((new GenerateResponse<UserResponse>()).generateSuccessResponseWithData(responseWithData));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> retrieveById(@PathVariable String id) {


		UserResponse responseWithData = new UserResponse();
		
		var messages = new ArrayList<String>();
		messages.add("La ciudad se consultaron de forma satisfactoria");
		
		var list = new ArrayList<UserDTO>();
		
		responseWithData.setData(list);
		responseWithData.setMessages(messages);
		
		return ((new GenerateResponse<UserResponse>()).generateSuccessResponseWithData(responseWithData));
	}
	
}
