package co.sdj.sdjgym.businesslogic.usecase.eps.impl;

import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.sdjgym.businesslogic.adapter.entity.EpsEntityAdapter;
import co.sdj.sdjgym.businesslogic.usecase.eps.FindEps;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.EpsDomain;

public class FindEpsImpl implements FindEps{
	
	
	private DAOFactory daoFactory;
	
	public FindEpsImpl(DAOFactory daoFactory) {
		setDaoFactory(daoFactory);
	}
	
	
	@Override
	public List<EpsDomain> execute() {
		
		
			return EpsEntityAdapter.getEpsEntityAdapter().adaptTarget(daoFactory.getEpsDAO().findAll());
		
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
