package co.sdj.sdjgym.businesslogic.usecase.country.impl;

import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.sdjgym.businesslogic.adapter.entity.CountryEntityAdapter;
import co.sdj.sdjgym.businesslogic.usecase.country.FindCountry;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;

import co.sdj.sdjgym.domain.CountryDomain;

public class FindCountryImpl implements FindCountry{
	
	private DAOFactory daofactory;
	
	public FindCountryImpl(DAOFactory daoFactory) {
		setDaofactory(daoFactory);
	}
	

	@Override
	public List<CountryDomain> execute(final CountryDomain data) {
		var CountryEntity = CountryEntityAdapter.getCountryEntityAdapter().adaptSource(data);
		return CountryEntityAdapter.getCountryEntityAdapter().adaptTarget(daofactory.getCountryDAO().findAll());
	}



	public void setDaofactory(final DAOFactory daofactory) {
		
		if(ObjectHelper.isNull(daofactory)) {
			var userMessage = "Se ha presentado un problema inesperado, tratando de llevar a cabo la busqueda del  registro de la información de el nuevo país deseada. Por favor intente de nuevo y si el problema persiste, llame a Luz Mery Ríos Alzate...";
			var technicalMessage = "El dao factory requerido para buscar la clase que actualiza el país llegó nula...";
			throw BusinessLogicSdjException.crear(userMessage, technicalMessage);
		}
		this.daofactory = daofactory;
	}

}

