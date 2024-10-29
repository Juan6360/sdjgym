package co.sdj.sdjgym.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.crosscutting.exceptions.DataSdjException;
import co.sdj.sdjgym.data.dao.CityDAO;
import co.sdj.sdjgym.data.dao.CountryDAO;
import co.sdj.sdjgym.data.dao.impl.sql.SqlDAO;
import co.sdj.sdjgym.entity.CityEntity;
import co.sdj.sdjgym.entity.CountryEntity;

public class CitySqlServerDAO extends SqlDAO implements CityDAO {

	protected CitySqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(final CityEntity data) {
		 
		final StringBuilder statement = new StringBuilder();
		statement.append("INSERT INTO City(id, name, state) VALUES (?, ?,?)");
 
		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())) {
 
			preparedStatement.setObject(1, data.getId());
			preparedStatement.setString(2, data.getName());
			preparedStatement.setObject(3, data.getState().getId());
 
			preparedStatement.executeUpdate();
 
		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo el registro de la información del nuevo país. Por favor intente de nuevo y si el problema persiste reporte la novedad...";
			var technicalMessage = "Se ha presentado un problema al tratar de registrar la informaciòn del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
 
			throw DataSdjException.crear(userMessage, technicalMessage, exception);
		}
 
	}

	@Override
	public CityEntity findByID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filter) {
		return null;
	}

	@Override
	public void update(final CityEntity data) {
		
		final StringBuilder statement = new StringBuilder();
		statement.append("UPDATE City SET name = ?, state = ? WHERE id = ?");
 
		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())) {
 
			preparedStatement.setObject(1, data.getName());
			preparedStatement.setObject(2, data.getState().getId());
			preparedStatement.setObject(3, data.getId());
 
			preparedStatement.executeUpdate();
 
		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo el registro de la información del nuevo país. Por favor intente de nuevo y si el problema persiste reporte la novedad...";
			var technicalMessage = "Se ha presentado un problema al tratar de registrar la informaciòn del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
 
			throw DataSdjException.crear(userMessage, technicalMessage, exception);
		}
 
	}
		


	@Override
	public void delete(UUID data) {
		
		final StringBuilder statement = new StringBuilder();
		statement.append("DELETE FROM City WHERE id = ?)");
 
		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())) {
 
			preparedStatement.setObject(1, data);
			
 
			preparedStatement.executeUpdate();
 
		} catch (final SQLException exception) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo el registro de la información del nuevo país. Por favor intente de nuevo y si el problema persiste reporte la novedad...";
			var technicalMessage = "Se ha presentado un problema al tratar de registrar la informaciòn del nuevo país en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
 
			throw DataSdjException.crear(userMessage, technicalMessage, exception);
		}
 
	}
	
	private void createSelect(final StringBuilder statement) {
		statement.append("SELECT id, name ");
	}
	private void createFrom(final StringBuilder statement) {
		statement.append("FROM Country ");
	}
	
	private void createWhere(final StringBuilder statement,
			final CityEntity filter,
			final List<Object> parameters) {
		
		if(!ObjectHelper.isNull(filter)) {
			
			if(UUIDHelper.isDefault(filter.getId())) {
				statement.append("WHERE id = ?");
				parameters.add(filter.getId());
			}
			
			if(!TextHelper.isEmptyApplyingTrim(filter.getName()));{
				statement.append((parameters.isEmpty()) ? "WHERE " : "AND ");
				statement.append("name = ?");
				parameters.add(filter.getName());
			}
		}
	}
	
	private void createOrderBy(final StringBuilder statement) {
		statement.append("ORDER BY name ASC ");
	}

}
