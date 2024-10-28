package co.edu.uco.ucobet.businesslogic.usecase.city.impl;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.businesslogic.usecase.city.UpdateCity;
import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.domain.CityDomain;

public final class UpdateCityImpl implements UpdateCity{

	private DAOFactory daoFactory;
	
	public UpdateCityImpl(DAOFactory daoFactory) {
		
	}
	
	
	
	@Override
	public void execute(CityDomain data) {
		// TODO Auto-generated method stub
		
	}
	
	private void setDaoFactory(final DAOFactory daoFactory) {
		if(ObjectHelper.isNull(daoFactory)) {
			
		}
		
		this.daoFactory= daoFactory;
	}

}
