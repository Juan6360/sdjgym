package co.sdj.sdjgym.businesslogic.usecase.city.impl;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.sdjgym.businesslogic.usecase.city.UpdateCity;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.CityDomain;

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
