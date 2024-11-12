package co.sdj.sdjgym.businesslogic.usecase.user.state.rules.impl;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.sdjgym.businesslogic.usecase.user.state.rules.StateExists;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.entity.StateEntity;



public final class StateExistsImpl implements StateExists {

	@Override
	public final  void execute(final UUID data, DAOFactory factory) {
		var state = ObjectHelper.getDefault(factory.getStateDAO().findByID(data), new StateEntity());

		if (data.compareTo(state.getId()) != 0) {
			var userMessage = "No existe un departamento con el identificador " + data.toString();
			throw BusinessLogicSdjException.crear(userMessage);
		}

	}

}
