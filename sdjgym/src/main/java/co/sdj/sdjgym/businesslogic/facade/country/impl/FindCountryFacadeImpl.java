package co.sdj.sdjgym.businesslogic.facade.country.impl;

import java.util.List;

import co.sdj.sdjgym.businesslogic.adapter.dto.CountryDTOAdapter;
import co.sdj.sdjgym.businesslogic.facade.country.FindCountryFacade;
import co.sdj.sdjgym.businesslogic.usecase.country.impl.FindCountryImpl;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.crosscutting.exceptions.SdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.data.dao.enums.DAOSource;
import co.sdj.sdjgym.dto.CountryDTO;

public class FindCountryFacadeImpl implements FindCountryFacade{

	@Override
	public List<CountryDTO> execute(CountryDTO data) {
		
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);

		try {
			var findCountryUseCase = new FindCountryImpl(factory);
			var countryDomain = CountryDTOAdapter.getCountryDTOAdapter().adaptSource(data);

			return CountryDTOAdapter.getCountryDTOAdapter().adaptTarget(findCountryUseCase.execute());

		} catch (final SdjException exception) {
			throw exception;
		} catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema tratando consultar la información de los paises...";
			var technicalMessage = "Se ha presentado un problema inesperado consultando la información de los paises. Por favor revise el log de errores para tener más detalles...";

			throw BusinessLogicSdjException.crear(userMessage, technicalMessage, exception);
		} finally {
			factory.closeConnection();
		}
	}

}
