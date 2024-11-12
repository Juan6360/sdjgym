package co.sdj.sdjgym.businesslogic.usecase.user.identificationType.rules.impl;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.sdjgym.businesslogic.usecase.user.identificationType.rules.IdentificationTypeExists;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.entity.IdentificationTypeEntity;



public final class IdentificationTypeExistsImpl implements IdentificationTypeExists {

	@Override
	public final void execute(final UUID data, DAOFactory factory) {
		var identificationType = ObjectHelper.getDefault(factory.getIdentificationTypeDAO().findByID(data), new IdentificationTypeEntity());

		if (data.compareTo(identificationType.getId()) != 0) {
			var userMessage = "No existe un tipo de identificacion con el identificador " + data.toString();
			throw BusinessLogicSdjException.crear(userMessage);
		}

	}

}
