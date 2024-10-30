package co.sdj.sdjgym.businesslogic.facade.city.impl;

import co.sdj.sdjgym.businesslogic.facade.city.RegisterNewCityFacade;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.data.dao.enums.DAOSource;
import co.sdj.sdjgym.dto.CityDTO;

public class RegisterNewCityFacadeImpl implements RegisterNewCityFacade {

	@Override
	public void execute(CityDTO data) {
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
	}

}
