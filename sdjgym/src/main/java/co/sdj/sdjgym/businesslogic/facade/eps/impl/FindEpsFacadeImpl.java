package co.sdj.sdjgym.businesslogic.facade.eps.impl;

import java.util.List;

import co.sdj.sdjgym.businesslogic.adapter.dto.EpsDTOAdapter;
import co.sdj.sdjgym.businesslogic.facade.eps.FindEpsFacade;
import co.sdj.sdjgym.businesslogic.usecase.eps.impl.FindEpsImpl;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.crosscutting.exceptions.SdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.data.dao.enums.DAOSource;
import co.sdj.sdjgym.dto.EpsDTO;

public final class FindEpsFacadeImpl implements FindEpsFacade{

	@Override
	public List<EpsDTO> execute(final EpsDTO data) {
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);

		try {
			var findEpsUseCase = new FindEpsImpl(factory);
			var epsDomain = EpsDTOAdapter.getEpsDTOAdapter().adaptSource(data);

			return EpsDTOAdapter.getEpsDTOAdapter().adaptTarget(findEpsUseCase.execute());

		} catch (final SdjException exception) {
			throw exception;
		} catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema tratando consultar la información de las EPS...";
			var technicalMessage = "Se ha presentado un problema inesperado consultando la información de las EPS. Por favor revise el log de errores para tener más detalles...";

			throw BusinessLogicSdjException.crear(userMessage, technicalMessage, exception);
		} finally {
			factory.closeConnection();
		}
	}

}
	

