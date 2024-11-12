package co.sdj.sdjgym.businesslogic.usecase.user.impl;

import java.util.Collections;
import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.entity.UserEntityAdapter;
import co.sdj.sdjgym.businesslogic.usecase.user.FindUser;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.UserDomain;

public final class FindUserImpl implements FindUser{
	
	private DAOFactory daoFactory;
   
	
	public FindUserImpl (DAOFactory daoFactory) {
		setDaoFactory(daoFactory);

	}

	@Override
	public List<UserDomain> execute(UserDomain data) {
		
		var userEntity = UserEntityAdapter.getUserEntityAdapter().adaptSource(data);
		
		if (UUIDHelper.isDefault(data.getId())) {
	        return UserEntityAdapter.getUserEntityAdapter().adaptTarget(daoFactory.getUserDAO().findByFilter(userEntity));
			
	    }  else if (!TextHelper.isEmpty(data.getFirstName())){
	    	//Collections.singletonList retorna una lista con solo un parametro, y esta lista es inmutable
	    	 return Collections.singletonList(UserEntityAdapter.getUserEntityAdapter().adaptTarget(daoFactory.getUserDAO().findByID(userEntity.getId())));
	    
	    } else {
	        
	        return UserEntityAdapter.getUserEntityAdapter().adaptTarget(daoFactory.getUserDAO().findAll());
	    }
	}
	
	private void setDaoFactory(DAOFactory daoFactory) {
		if (ObjectHelper.isNull(daoFactory)) {
			var userMessage = "se ha presentado un problema inesperado tratando de llevar a cabo la modificación de modificacion de la informacion de la cuidad deseada.porfavor intenta de nuevo y si el problema persiste llame a luz mery rios Alzate..";
			var technicalMessage = "El dao factory requerido para crear la clase que se actualiza la cuidad llegó nula.";
			throw BusinessLogicSdjException.crear(userMessage, technicalMessage);
		}
		this.daoFactory = daoFactory;
	}

}
