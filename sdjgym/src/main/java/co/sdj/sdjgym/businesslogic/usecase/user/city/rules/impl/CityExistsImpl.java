package co.sdj.sdjgym.businesslogic.usecase.user.city.rules.impl;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.sdjgym.businesslogic.usecase.user.city.rules.CityExists;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.entity.CityEntity;

public final class CityExistsImpl implements CityExists {

	@Override
	public final void execute(final UUID data, DAOFactory factory) {
		var city = ObjectHelper.getDefault(factory.getCityDAO().findByID(data), new CityEntity());

		if (data.compareTo(city.getId()) != 0) {
			var userMessage = "No existe una cuidad con el identificador " + data.toString();
			throw BusinessLogicSdjException.crear(userMessage);
		}

	}

}
