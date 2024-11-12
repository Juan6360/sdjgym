package co.sdj.sdjgym.businesslogic.facade.identificationType.impl;

import java.util.List;

import co.sdj.sdjgym.businesslogic.adapter.dto.CountryDTOAdapter;
import co.sdj.sdjgym.businesslogic.adapter.dto.IdentificationTypeDTOAdapter;
import co.sdj.sdjgym.businesslogic.facade.identificationType.FindIdentificationTypeFacade;
import co.sdj.sdjgym.businesslogic.usecase.country.impl.FindCountryImpl;
import co.sdj.sdjgym.businesslogic.usecase.identificationType.impl.FindIdentificationTypeImpl;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.crosscutting.exceptions.SdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.data.dao.enums.DAOSource;
import co.sdj.sdjgym.dto.CountryDTO;
import co.sdj.sdjgym.dto.IdentificationTypeDTO;

public final class FindIdentificationTypeFacadeImpl implements FindIdentificationTypeFacade {


	@Override
	public List<IdentificationTypeDTO> execute(final IdentificationTypeDTO data) {
		
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);

		try {
			var findIdentificationTypeUseCase = new FindIdentificationTypeImpl(factory);
			var IdentificationTypeDomain = IdentificationTypeDTOAdapter.getIdentificationTypeDTOAdapter().adaptSource(data);

			return IdentificationTypeDTOAdapter.getIdentificationTypeDTOAdapter().adaptTarget(findIdentificationTypeUseCase.execute());

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

