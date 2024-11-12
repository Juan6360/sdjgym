package co.sdj.sdjgym.businesslogic.usecase.city.impl;

import java.util.List;

import co.sdj.sdjgym.businesslogic.usecase.city.FindCity;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.CityDomain;

public final class FindCityImpl implements FindCity {

	private DAOFactory daoFactory;
	
	public FindCityImpl(final DAOFactory daoFactory) {
		setDaoFactory(daoFactory);
	}

	private void setDaoFactory(final DAOFactory daoFactory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CityDomain> execute(CityDomain data) {
		// TODO Auto-generated method stub
		return null;
	}
}