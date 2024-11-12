package co.sdj.sdjgym.businesslogic.facade.user;

import co.sdj.sdjgym.businesslogic.adapter.dto.UserDTOAdapter;
import co.sdj.sdjgym.businesslogic.usecase.user.impl.RegisterUserImpl;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.crosscutting.exceptions.SdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.data.dao.enums.DAOSource;
import co.sdj.sdjgym.dto.UserDTO;

public class RegisterUserFacadeImpl implements RegisterUserFacade {

	@Override
	public void execute(final UserDTO data) {

		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);

		try {
			factory.initTransaction();

			var registerNewUserUseCase = new RegisterUserImpl(factory);
			var userDomain = UserDTOAdapter.getUserDTOAdapter().adaptSource(data);

			registerNewUserUseCase.execute(userDomain);

			factory.commitTransaction();
		} catch (final SdjException exception) {
			factory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {

			factory.rollbackTransaction();

			var userMessage = "Se ha presentado un problema tratando registrar la información de el nuevo usuario...";
			var technicalMessage = "Se ha presentado un problema inesperado registrando la información de el nuevo usuario. Por favor revise el log de errores para tener más detalles...";

			throw BusinessLogicSdjException.crear(userMessage, technicalMessage, exception);
		} finally {
			factory.closeConnection();
		}
	}
	
}
