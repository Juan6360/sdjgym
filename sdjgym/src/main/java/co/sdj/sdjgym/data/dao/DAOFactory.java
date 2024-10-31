package co.sdj.sdjgym.data.dao;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.sdjgym.crosscutting.exceptions.DataSdjException;
import co.sdj.sdjgym.data.dao.enums.DAOSource;
import co.sdj.sdjgym.data.dao.impl.sql.sqlserver.SqlServerDAOFactory;

public abstract class DAOFactory {

	public final static DAOFactory getFactory(final DAOSource source) {
		
		switch(source) {
		case SQLSERVER: {
			return new SqlServerDAOFactory();
		}
		default:
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseda...";
			var technicalMessage = TextHelper.concat("No existe una factoria implementada para ", source.toString());
			throw DataSdjException.crear(userMessage, technicalMessage);
		}
	}

	protected abstract void openConnection();

	public abstract void initTransaction();

	public abstract void commitTransaction();

	public abstract void rollbackTransaction();

	public abstract void closeConnection();

	public abstract CityDAO getCityDAO();

	public abstract StateDAO getStateDAO();

	public abstract CountryDAO getCountryDAO();

}
