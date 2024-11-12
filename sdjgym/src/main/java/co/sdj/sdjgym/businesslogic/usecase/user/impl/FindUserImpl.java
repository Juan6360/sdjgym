package co.sdj.sdjgym.businesslogic.usecase.user.impl;

import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.sdjgym.businesslogic.adapter.entity.IdentificationTypeEntityAdapter;
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
		
		var UserEntity = UserEntityAdapter.getuserEntityAdapter().adaptSource(data);
		
		if (!ObjectHelper.isNull(data)) {
	        return IdentificationTypeEntityAdapter.getIdentificationTypeEntityAdapter().adaptSource(daoFactory.getIdentificationTypeDAO().findByFilter(listIdentificationTypeEntity));
			
	    } else if {
	    	
	    	return return IdentificationTypeEntityAdapter.getIdentificationTypeEntityAdapter().adaptSource(daoFactory.getIdentificationTypeDAO().findByFilter(listIdentificationTypeEntity));
	    
	    } else {
	        
	        return IdentificationTypeEntityAdapter.getIdentificationTypeEntityAdapter().adaptSource(daoFactory.getIdentificationTypeDAO().findAll());
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
