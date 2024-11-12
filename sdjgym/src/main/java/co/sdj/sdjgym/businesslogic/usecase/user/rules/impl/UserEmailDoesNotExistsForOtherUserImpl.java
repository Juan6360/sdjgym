package co.sdj.sdjgym.businesslogic.usecase.user.rules.impl;

import co.sdj.sdjgym.businesslogic.usecase.user.rules.UserEmailDoesNotExistsForOtherUser;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.UserDomain;
import co.sdj.sdjgym.entity.UserEntity;

public class UserEmailDoesNotExistsForOtherUserImpl implements UserEmailDoesNotExistsForOtherUser{

	@Override
	public void execute(UserDomain data, DAOFactory factory) {
		final var user = new UserEntity();
		user.setEmail(data.getEmail());
		
		
		var results = factory.getUserDAO().findByFilter(user);
		
		
		if (!results.isEmpty()) {
			var userMessage = "Ya existe un Correo "+results.get(0).getFirstName()+" "+results.get(0).getMiddleName() +"con el mismo " + results.get(0).getEmail();
			throw BusinessLogicSdjException.crear(userMessage);
		}
	}
	
	

}
