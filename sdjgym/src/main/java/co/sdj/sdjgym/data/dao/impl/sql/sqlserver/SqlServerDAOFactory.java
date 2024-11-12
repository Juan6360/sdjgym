package co.sdj.sdjgym.data.dao.impl.sql.sqlserver;

import java.sql.Connection;

import co.sdj.crosscutting.helpers.SqlConnectionHelper;
import co.sdj.sdjgym.data.dao.CityDAO;
import co.sdj.sdjgym.data.dao.CountryDAO;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.data.dao.EpsDAO;
import co.sdj.sdjgym.data.dao.IdentificationTypeDAO;
import co.sdj.sdjgym.data.dao.StateDAO;
import co.sdj.sdjgym.data.dao.UserDAO;

public final class SqlServerDAOFactory extends DAOFactory {

	private Connection connection;

	public SqlServerDAOFactory() {
		openConnection();
	}

	@Override
	protected void openConnection() {
		SqlConnectionHelper.validateIfConnectionIsOpen(connection);
		var connectionString = "jdbc:sqlserver://sdjgym-app.database.windows.net:1433;database=sdjgym;user=sdjgymDevelopTeam@sdjgym-app;password=UcoDoo2024!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		connection = SqlConnectionHelper.openConnection(connectionString);
	}

	@Override
	public void initTransaction() {
		SqlConnectionHelper.initTransaction(connection);
	}

	@Override
	public void commitTransaction() {
		SqlConnectionHelper.commitTransaction(connection);
	}

	@Override
	public void rollbackTransaction() {
		SqlConnectionHelper.rollbackTransaction(connection);
	}

	@Override
	public void closeConnection() {
		SqlConnectionHelper.closeConnection(connection);
	}

	@Override
	public CityDAO getCityDAO() {
		return new CitySqlServerDAO(connection);
	}

	@Override
	public StateDAO getStateDAO() {
		return new StateSqlServerDAO(connection);
	}

	@Override
	public CountryDAO getCountryDAO() {
		return new CountrySqlServerDAO(connection);
	}

	@Override
	public IdentificationTypeDAO getIdentificationTypeDAO() {
		return new IdentificationTypeSqlServerDAO(connection) ;
	}

	@Override
	public EpsDAO getEpsDAO() {
		return new EpsSqlServerDAO(connection);
	}

	@Override
	public UserDAO getUserDAO() {
		return new UserSqlServerDAO(connection);
	}

}
