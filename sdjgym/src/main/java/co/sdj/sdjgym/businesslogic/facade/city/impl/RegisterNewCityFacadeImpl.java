package co.sdj.sdjgym.businesslogic.facade.city.impl;

import co.sdj.sdjgym.businesslogic.adapter.dto.CityDTOAdapter;
import co.sdj.sdjgym.businesslogic.facade.city.RegisterNewCityFacade;
import co.sdj.sdjgym.businesslogic.usecase.city.impl.RegisterNewCityImpl;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.crosscutting.exceptions.SdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.data.dao.enums.DAOSource;
import co.sdj.sdjgym.dto.basedata.CityDTO;

public class RegisterNewCityFacadeImpl implements RegisterNewCityFacade {

	@Override
	public void execute(CityDTO data) {
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try {
			factory.initTransaction();
			
			var registerNewCityUseCase = new RegisterNewCityImpl(factory);
			var cityDomain = CityDTOAdapter.getCityDTOAdapter().adaptSource(data);
			
			registerNewCityUseCase.execute(cityDomain);
			
			factory.commitTransaction();
		} catch(final SdjException exception) {
			factory.rollbackTransaction();
			
			throw exception;
		} catch(final Exception exception) {
			factory.rollbackTransaction();
			
			var userMessage = "Se ha presentado un problema tratando registrar la información de la nnueva ciudad...";
			var technicalMessage = "Se ha presentado un problema inesperado registrando la información de la nueva ciudad. Por favor revise el log para tener más detalles...";
			
			throw BusinessLogicSdjException.crear(userMessage, technicalMessage);
		} finally {
			factory.closeConnection();
		}
	}

}
