package co.sdj.sdjgym.businesslogic.usecase.city.impl;
import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.sdjgym.businesslogic.adapter.entity.CityEntityAdapter;
import co.sdj.sdjgym.businesslogic.usecase.city.UpdateCity;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.basedata.CityDomain;

public final class UpdateCityImpl implements UpdateCity {
	
	private DAOFactory daoFactory;
	
	public UpdateCityImpl(DAOFactory daoFactory) {
		setDaoFactory(daoFactory);
	}

	@Override
	public void execute(final CityDomain data) {
		
		var cityEntity = CityEntityAdapter.getCityEntityAdapter().adaptTarget(data);
		daoFactory.getCityDAO().update(cityEntity);
		
	}

	private void setDaoFactory(final DAOFactory daoFactory) {
		if (ObjectHelper.isNull(daoFactory)) {
			var userMessage = "se ha presentado un problema inesperado tratando de llevar a cabo la modificación de la información de la cuidad deseada.porfavor intenta de nuevo y si el problema persiste llame a luz mery rios Alzate..";
			var technicalMessage = "El dao factory requerido para crear la clase que se actualiza la cuidad llegó nula.";
			throw BusinessLogicSdjException.crear(userMessage, technicalMessage);
		}
		this.daoFactory = daoFactory;
	}
	
	private boolean isCityNameTaken(final CityDomain data) {
		return daoFactory.getCityDAO().findByFilter(data.getName()) != null;
	}
}
