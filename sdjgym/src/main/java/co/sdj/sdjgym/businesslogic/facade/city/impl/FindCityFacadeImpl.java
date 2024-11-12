package co.sdj.sdjgym.businesslogic.facade.city.impl;

import java.util.List;

import co.sdj.sdjgym.businesslogic.adapter.dto.CityDTOAdapter;
import co.sdj.sdjgym.businesslogic.facade.city.FindCityFacade;
import co.sdj.sdjgym.businesslogic.usecase.city.impl.FindCityImpl;
import co.sdj.sdjgym.crosscutting.exceptions.DataSdjException;
import co.sdj.sdjgym.crosscutting.exceptions.SdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.data.dao.enums.DAOSource;
import co.sdj.sdjgym.dto.CityDTO;

public final class FindCityFacadeImpl implements FindCityFacade {
	
	@Override
	public List<CityDTO> execute(final CityDTO data) {
      var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try {
			var findCityUseCase = new FindCityImpl(factory);
			
			var cityDomain = CityDTOAdapter.getCityDTOAdapter().adaptSource(data);

			return CityDTOAdapter.getCityDTOAdapter().adaptTarget(findCityUseCase.execute(cityDomain));
			
			
		}catch(final SdjException exception) {
			
			throw exception;
		}catch(final Exception exception) {
			
			var userMessage = "se ha presentado un problema tratando de consultar la informacion de las nuevas  ciudadades.";
			var technicalMessage = " se ha presentado n problema inesperado registrando la informacion de la cuidad.porfavor revisar";
			throw DataSdjException.crear(userMessage, technicalMessage, exception);
		}finally {
			factory.closeConnection();
		}
	}


}
