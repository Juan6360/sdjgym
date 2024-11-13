package co.sdj.sdjgym.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sdj.crosscutting.exceptions.SdjApplicationException;
import co.sdj.sdjgym.businesslogic.facade.user.impl.RegisterUserFacadeImpl;
import co.sdj.sdjgym.controller.response.GenerateResponse;
import co.sdj.sdjgym.controller.response.concrete.GenericResponse;
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

			messages.add("El usuario se registró de forma satisfactoria");

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
					"Se ha presentado un problema inesperado tratando de llevar a cabo el registro del usuario de forma satisfactoria....");
			exception.printStackTrace();

			return GenerateResponse.generateFailedResponse(messages);
		}

	}
	
}
