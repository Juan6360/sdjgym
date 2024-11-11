package co.sdj.sdjgym.businesslogic.usecase.city.impl;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.entity.CityEntityAdapter;
import co.sdj.sdjgym.businesslogic.usecase.city.RegisterNewCity;
import co.sdj.sdjgym.businesslogic.usecase.city.rules.impl.CityNameConsistencyIsValidImpl;
import co.sdj.sdjgym.businesslogic.usecase.city.rules.impl.CityNameDoesNotExistsForStateImpl;
import co.sdj.sdjgym.businesslogic.usecase.city.state.rules.impl.StateExistsImpl;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.CityDomain;

public final class RegisterNewCityImpl implements RegisterNewCity {

	private DAOFactory daoFactory;
	private CityNameDoesNotExistsForStateImpl cityNameDoesNotExistsForState = new CityNameDoesNotExistsForStateImpl();
	private StateExistsImpl stateExists = new StateExistsImpl();
	private CityNameConsistencyIsValidImpl cityNameConsistencyIsValid = new CityNameConsistencyIsValidImpl();

	public RegisterNewCityImpl(final DAOFactory daoFactory) {
		setDaoFactory(daoFactory);
	}


	@Override
	public void execute(CityDomain data) {
		cityNameConsistencyIsValid.execute(data.getName());
		cityNameDoesNotExistsForState.execute(data, daoFactory);
		stateExists.execute(data.getState().getId(), daoFactory);

		var cityDomainToMap = CityDomain.create(generateId(), data.getName(), data.getState());
		var cityEntity = CityEntityAdapter.getCityEntityAdapter().adaptSource(cityDomainToMap);
		daoFactory.getCityDAO().create(cityEntity);
	}

	private UUID generateId() {
		var id = UUIDHelper.generate();
		var cityEntity = daoFactory.getCityDAO().findByID(id);

		if (UUIDHelper.isEqual(cityEntity.getId(), id)) {
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
	

