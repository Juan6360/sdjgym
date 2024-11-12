package co.sdj.sdjgym.businesslogic.usecase.city.impl;

import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.sdjgym.businesslogic.adapter.entity.CityEntityAdapter;
import co.sdj.sdjgym.businesslogic.usecase.city.FindCity;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.CityDomain;

public final class FindCityImpl implements FindCity {
	private DAOFactory daofactory;
	
	public FindCityImpl(DAOFactory daoFactory) {
		setDaofactory(daoFactory);
	}
	

	@Override
	public List<CityDomain> execute(final CityDomain data) {
		var CityEntity = CityEntityAdapter.getCityEntityAdapter().adaptSource(data);
		return CityEntityAdapter.getCityEntityAdapter().adaptTarget(daofactory.getCityDAO().findAll());
	}



	public void setDaofactory(final DAOFactory daofactory) {
		
		if(ObjectHelper.isNull(daofactory)) {
			var userMessage = "Se ha presentado un problema inesperado, tratando de llevar a cabo la busqueda del  registro de la información de la nueva ciudad deseada. Por favor intente de nuevo y si el problema persiste, llame a Luz Mery Ríos Alzate...";
			var technicalMessage = "El dao factory requerido para buscar la clase que actualiza la ciudad llegó nula...";
			throw BusinessLogicSdjException.crear(userMessage, technicalMessage);
		}
		this.daofactory = daofactory;
	}

}
