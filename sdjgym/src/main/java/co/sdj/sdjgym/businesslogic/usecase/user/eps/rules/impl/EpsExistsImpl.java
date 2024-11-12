package co.sdj.sdjgym.businesslogic.usecase.user.eps.rules.impl;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.sdjgym.businesslogic.usecase.user.eps.rules.EpsExists;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.entity.EpsEntity;

public final class EpsExistsImpl implements EpsExists {

	@Override
	public final void execute(final UUID data, DAOFactory factory) {
		var eps = ObjectHelper.getDefault(factory.getEpsDAO().findByID(data), new EpsEntity());

		if (data.compareTo(eps.getId()) != 0) {
			var userMessage = "No existe una eps con el identificador " + data.toString();
			throw BusinessLogicSdjException.crear(userMessage);
		}

	}

}
