package co.sdj.sdjgym.businesslogic.usecase.city.impl;

import java.util.UUID;
import co.sdj.sdjgym.businesslogic.usecase.city.state.rules.StateExists;
import co.sdj.sdjgym.businesslogic.usecase.city.rules.impl.CityNameDoesNotExistsForStateImpl;
import co.sdj.sdjgym.businesslogic.usecase.city.rules.impl.CityNameConsistencyIsValidImpl;
import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.entity.CityEntityAdapter;
import co.sdj.sdjgym.businesslogic.usecase.city.RegisterNewCity;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.CityDomain;
import co.sdj.sdjgym.businesslogic.usecase.city.rules.CityNameConsistencyIsValid;
import co.sdj.sdjgym.businesslogic.usecase.city.rules.CityNameDoesNotExistsForState;
import co.sdj.sdjgym.businesslogic.usecase.city.state.rules.impl.StateExistsImpl;

public final class RegisterNewCityImpl implements RegisterNewCity{

	private DAOFactory daoFactory;
	private CityNameDoesNotExistsForState cityNameDoesNotExistsForState= new CityNameDoesNotExistsForStateImpl();
	private StateExists stateExists = new StateExistsImpl();
	private CityNameConsistencyIsValid cityNameConsistencyIsValid = new CityNameConsistencyIsValidImpl();
	
	public RegisterNewCityImpl (final DAOFactory daoFactory) {
		setDaoFactory(daoFactory);
	}

	@Override
	public void execute(final CityDomain data) {
		
		cityNameConsistencyIsValid.execute(data.getName());
		cityNameDoesNotExistsForState.execute(data.getName());
		stateExists.execute(data.getState().getId(), daoFactory);
		
		var CityDomainToMap = CityDomain.create(generateId(), data.getName(), data.getState());
		var cityEntity = CityEntityAdapter.getCityEntityAdapter().adaptTarget(data);
		daoFactory.getCityDAO().create(cityEntity);
		
	}
	
	private UUID generateId() {
		var id = UUIDHelper.generate();
		var cityEntity = daoFactory.getCityDAO().findByID(id);
		
		if(UUIDHelper.isEqual(cityEntity.getId(), id)) {
			id = generateId();
		}
		
		return id;
	}

	private void setDaoFactory(final DAOFactory daoFactory) {
		if (ObjectHelper.isNull(daoFactory)) {
			var userMessage = "se ha presentado un problema inesperado tratando de llevar a cabo la modificación de la información de la cuidad deseada.porfavor intenta de nuevo y si el problema persiste llame a luz mery rios Alzate..";
			var technicalMessage = "El dao factory requerido para crear la clase que se actualiza la cuidad llegó nula.";
			throw BusinessLogicSdjException.crear(userMessage, technicalMessage);
		}
		this.daoFactory = daoFactory;
	}
	


}
