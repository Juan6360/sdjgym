package co.sdj.sdjgym.businesslogic.usecase.user.impl;


import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.entity.UserEntityAdapter;
import co.sdj.sdjgym.businesslogic.usecase.user.RegisterUser;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.impl.UserBirthdayConsistencyIsValidImpl;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.impl.UserNumberConsistencyIsValidImpl;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.impl.UserStringConsistencyIsValidImpl;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.UserDomain;

public final class RegisterUserImpl implements RegisterUser{
	
	private DAOFactory daoFactory;
	private UserStringConsistencyIsValidImpl userStringConsistencyIsValidImpl = new UserStringConsistencyIsValidImpl();
	private UserNumberConsistencyIsValidImpl userNumberConsistencyIsValidImpl = new UserNumberConsistencyIsValidImpl();
	private UserBirthdayConsistencyIsValidImpl userBirthdayConsistencyIsValidImpl = new UserBirthdayConsistencyIsValidImpl();
	
	public RegisterUserImpl(final DAOFactory daoFactory) {
		setDaoFactory(daoFactory);
	}

	@Override
	public void execute(UserDomain data) {
		
		
		userStringConsistencyIsValidImpl.execute(data.getFirstName());
		userStringConsistencyIsValidImpl.execute(data.getMiddleName());
		userStringConsistencyIsValidImpl.execute(data.getFirstSurName());
		userStringConsistencyIsValidImpl.execute(data.getSecondSurName());
		
		userNumberConsistencyIsValidImpl.execute(data.getPhoneNumber());
		userNumberConsistencyIsValidImpl.execute(data.getEmergencyNumber());
		userNumberConsistencyIsValidImpl.execute(data.getIdentificacion());
		
		userBirthdayConsistencyIsValidImpl.execute(data.getBirthDate());
		
		var userDomainToMap = UserDomain.create(generateId(), data.getFirstName(), data.getMiddleName(), data.getFirstSurName(), data.getSecondSurName(), data.getPhoneNumber(), data.getEmergencyNumber(), data.getEmail(), data.getBirthDate(), data.getIdentificationType(), data.getIdentificacion(), data.getEps(), data.getAddress(), data.getState(), data.getCity());
		var userEntity = UserEntityAdapter.getUserEntityAdapter().adaptSource(userDomainToMap);
		daoFactory.getUserDAO().create(userEntity);
		
	}

	private UUID generateId() {
		var id = UUIDHelper.generate();
		var userEntity = daoFactory.getUserDAO().findByID(id);
		
		if(UUIDHelper.isEqual(userEntity.getId(), id)) {
			id = generateId();
		}
		return id;
	}
	
	private void setDaoFactory(final DAOFactory daoFactory) {
		if (ObjectHelper.isNull(daoFactory)) {
			var userMessage = "Se ha presentado un problema inesperado, tratando de llevar a cabo el registro de la información de la nueva ciudad deseada. Por favor intente de nuevo y si el problema persiste, llame a Luz Mery Ríos Alzate...";
			var technicalMessage = "El dao factory requerido para crear la clase que actualiza la ciudad llegó nula...";
			throw BusinessLogicSdjException.crear(userMessage, technicalMessage);
		}

		this.daoFactory = daoFactory;
		
	}
}
