package co.sdj.sdjgym.businesslogic.facade.State.impl;

import java.util.List;

import co.sdj.sdjgym.businesslogic.adapter.dto.StateDTOAdapter;
import co.sdj.sdjgym.businesslogic.facade.State.FindStateFacade;
import co.sdj.sdjgym.businesslogic.usecase.state.impl.FindStateImpl;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.crosscutting.exceptions.SdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.data.dao.enums.DAOSource;
import co.sdj.sdjgym.dto.StateDTO;

public class FindStateFacadeImpl implements FindStateFacade {

@Override
public List<StateDTO> execute(StateDTO data) {
	var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);

	try {
		var findStateUseCase = new FindStateImpl(factory);

		return StateDTOAdapter.getStateDTOAdapter().adaptTarget(findStateUseCase.execute());

	} catch (final SdjException exception) {
		throw exception;
	} catch (final Exception exception) {
		var userMessage = "Se ha presentado un problema tratando consultar la información de los estados...";
		var technicalMessage = "Se ha presentado un problema inesperado consultando la información de los estados. Por favor revise el log de errores para tener más detalles...";

		throw BusinessLogicSdjException.crear(userMessage, technicalMessage, exception);
	} finally {
		factory.closeConnection();
	}
}

}

