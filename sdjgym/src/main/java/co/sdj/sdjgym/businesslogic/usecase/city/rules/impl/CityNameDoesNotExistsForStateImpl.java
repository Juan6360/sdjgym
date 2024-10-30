package co.sdj.sdjgym.businesslogic.usecase.city.rules.impl;

import co.sdj.sdjgym.businesslogic.usecase.city.rules.CityNameDoesNotExistsForState;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.CityDomain;
import co.sdj.sdjgym.entity.CityEntity;
import co.sdj.sdjgym.entity.StateEntity;

public class CityNameDoesNotExistsForStateImpl implements CityNameDoesNotExistsForState {

	@Override
	public void execute(CityDomain data, DAOFactory factory) {
		final var city = new CityEntity();
		city.setName(data.getName());
		
		final var state = new StateEntity();
		state.setId(data.getState().getId());
		
		city.setState(state);
		
		var results = factory.getCityDAO().findByFilter(city);
		
		if(results.isEmpty()) {
			var userMessage = "se ha presentado un problema inesperado tratando de llevar a cabo la modificación de la información de la cuidad deseada.porfavor intenta de nuevo y si el problema persiste llame a luz mery rios Alzate..";
			var technicalMessage = "El dao factory requerido para crear la clase que se actualiza la cuidad llegó nula.";
			throw BusinessLogicSdjException.crear(userMessage, technicalMessage);
		}
	}

}
