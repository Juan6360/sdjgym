package co.sdj.sdjgym.data.dao;

import co.sdj.sdjgym.data.dao.enums.DAOSource;

public abstract class DAOFactory {

	public final static DAOFactory getFactory(final DAOSource source) {
		return null;
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
