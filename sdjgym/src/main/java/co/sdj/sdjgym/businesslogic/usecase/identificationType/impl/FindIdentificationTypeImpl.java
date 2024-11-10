package co.sdj.sdjgym.businesslogic.usecase.identificationType.impl;

import java.util.List;


import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.sdjgym.businesslogic.adapter.entity.IdentificationTypeEntityAdapter;
import co.sdj.sdjgym.businesslogic.usecase.identificationType.FindIdentificationType;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;

import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.IdentificationTypeDomain;

public final class FindIdentificationTypeImpl implements FindIdentificationType {
	
	private DAOFactory daoFactory;
	
	public FindIdentificationTypeImpl(DAOFactory daoFactory) {
		setDaoFactory(daoFactory);
	}
	
	
	@Override
	public List<IdentificationTypeDomain> execute(final IdentificationTypeDomain data) {
		
		
		var listIdentificationTypeEntity = IdentificationTypeEntityAdapter.getIdentificationTypeEntityAdapter().adaptTarget(data);
		return IdentificationTypeEntityAdapter.getIdentificationTypeEntityAdapter().adaptSource(daoFactory.getIdentificationTypeDAO().findAll()) ;
	}


	public void setDaoFactory(final DAOFactory daoFactory) {
		
		if(ObjectHelper.isNull(daoFactory)) {
			var userMenssage = "Se a presentado un problema inesperado tratando de llevar a cabo la consulta de los tipos de identificación deseados, por favor intente de nuevo, y si el problema persiste reporte la novedad...";
			var technicalMessage="El Dao factory requerido pra consultar el tipo de Identificación llegó nulo...";
			throw BusinessLogicSdjException.crear(userMenssage, technicalMessage);
		}
		
		this.daoFactory = daoFactory;
	}


	
	
	
}
