package co.sdj.sdjgym.businesslogic.usecase.city.rules.impl;

import co.sdj.sdjgym.businesslogic.usecase.city.rules.CityNameDoesNotExistsForState;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.basedata.CityDomain;
import co.sdj.sdjgym.entity.CityEntity;
import co.sdj.sdjgym.entity.StateEntity;


public final class CityNameDoesNotExistsForStateImpl implements CityNameDoesNotExistsForState {

	@Override
	public void execute(final CityDomain data, final DAOFactory factory) {

		final var city= new CityEntity();
		city.setName(data.getName());
		
		final var state = new StateEntity();
		state.setId(data.getState(). getId());
		
		city.setState(state);
		
		var results = factory.getCityDAO().findByFilter(city);
		
		if (!results.isEmpty()) {
		  var userMessage = "ya existe una cuidad llamada " + city.getName() + "para el departamento" + results.get(0).getState().getName();
		  throw BusinessLogicSdjException.crear(userMessage);
	    }
		
	}
	


}
