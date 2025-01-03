package co.sdj.sdjgym.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import co.sdj.crosscutting.helpers.DateHelper;
import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.crosscutting.exceptions.DataSdjException;
import co.sdj.sdjgym.data.dao.UserDAO;
import co.sdj.sdjgym.data.dao.impl.sql.SqlDAO;
import co.sdj.sdjgym.entity.UserEntity;

public final class UserSqlServerDAO extends SqlDAO implements UserDAO{

	protected UserSqlServerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void create(final UserEntity data) {
		final StringBuilder statement = new StringBuilder();
		statement.append("INSERT INTO [User] (id, firstName,middleName,firstSurName,secondSurName,"
				+ "phoneNumber,emergencyNumber,email,birthDate,identificationType,identification,eps,"
				+ "address, city) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		try(final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			preparedStatement.setObject(1, data.getId());
			preparedStatement.setString(2, data.getFirstName());
			preparedStatement.setString(3, data.getMiddleName());
			preparedStatement.setString(4, data.getFirstSurName());
			preparedStatement.setString(5, data.getSecondSurName());
			preparedStatement.setString(6, data.getPhoneNumber());
			preparedStatement.setString(7, data.getEmergencyNumber());
			preparedStatement.setString(8, data.getEmail());
			preparedStatement.setDate(9,	DateHelper.cambio(data.getBirthDate()));
			preparedStatement.setObject(10, data.getIdentificationType().getId());
			preparedStatement.setString(11, data.getIdentification());
			preparedStatement.setObject(12, data.getEps().getId());
			preparedStatement.setString(13, data.getAddress());
			preparedStatement.setObject(14, data.getCity().getId());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMenssage = "Se a presentado un problema inesperado tratando de llevar a cabo el registro de la información de un nuevo Usuario. Por favor intente de nuevo, y si el problema persiste reporte la novedad...";
			var technicalMessage="Se a presentado un problema al tratar de registrar la información del nuevo Usuario en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			throw DataSdjException.crear(userMenssage, technicalMessage, exception);
		}
			
	}

	@Override
	public UserEntity findByID(UUID id) {
		var userEntityFilter = new UserEntity();
		userEntityFilter.setId(id);
		
		var result = findByFilter(userEntityFilter);
		
		return (result.isEmpty())? new UserEntity(): result.get(0);
	}

	@Override
	public List<UserEntity> findAll() {
		
		return findByFilter(new UserEntity());
	}

	@Override
	public List<UserEntity> findByFilter(UserEntity filter) {
		final var statement = new StringBuilder();
		final var parameters = new ArrayList<>();
		final var resultSelect= new ArrayList<UserEntity>();
		var statementWasPrepared = false;
		
		createSelect(statement);
		createFrom(statement);
		createWhere(statement, filter, parameters);
		createOrderBy(statement);
		
		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			for(var arrayIndex = 0; arrayIndex < parameters.size(); arrayIndex++) {
				var statementIndex = arrayIndex +1;
				preparedStatement.setObject(statementIndex, parameters.get(arrayIndex));
				
			}
			statementWasPrepared = true;
			
			final var result = preparedStatement.executeQuery();
				
			while(result.next()) {
				var userEntityTmp = new UserEntity();
				userEntityTmp.setId(UUIDHelper.convertToUUID(result.getString("id")));
				userEntityTmp.setFirstName(result.getString("firstName"));
				userEntityTmp.setEmail(result.getString("email"));
				
				resultSelect.add(userEntityTmp);
			}	
			
			
			
			
		} catch (final SQLException exception) {
			var userMenssage = "Se a presentado un problema inesperado tratando de llevar a cabo la consulta de los usuarios por el filtro deseado, por favor intente de nuevo, y si el problema persiste reporte la novedad...";
			var technicalMessage="Se a presentado un problema al tratar de consultar la información de los usuarios por el filtro deseado en la base de datos SQL Server tratando de preparar la sentencia SQL que se iba a ejecutar, por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			if(statementWasPrepared) {
				technicalMessage="Se a presentado un problema al tratar de consultar la información de los usuarios por el filtro deseado en la base de datos SQL Server tratando de ejecutar la sentencia SQL definida, por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			}
			
			throw DataSdjException.crear(userMenssage, technicalMessage, exception);
		}
		
		return resultSelect;
	}

	private void createSelect(final StringBuilder statement) {
		statement.append("SELECT id, firstName, email ");
	}

	private void createFrom(final StringBuilder statement) {
		statement.append("FROM [User] ");
	}
	
	private void createWhere(final StringBuilder statement, final UserEntity filter, final List<Object> parameters) {
		
		if (!ObjectHelper.isNull(filter)) {
	        
			if (!UUIDHelper.isDefault(filter.getId())) {
				statement.append("WHERE id = ? ");
				parameters.add(filter.getId());
			}
			
			if (!TextHelper.isEmptyApplyingTrim(filter.getFirstName())) {
				statement.append((parameters.isEmpty()) ? "WHERE " : "AND ");
				statement.append("firstName = ? ");
				parameters.add(filter.getFirstName());
			}
			
			if (!TextHelper.isEmptyApplyingTrim(filter.getEmail())) {
				statement.append((parameters.isEmpty()) ? "WHERE " : "AND ");
				statement.append("email = ? ");
				parameters.add(filter.getEmail());
			}
			
	    }
		
	}

	private void createOrderBy(final StringBuilder statement) {
		statement.append("ORDER BY firstName ASC");
	}
	

	@Override
	public void delete(UUID data) {
		final StringBuilder statement = new StringBuilder();
		statement.append("DELETE FROM City WHERE id = ?");
		try(final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			
			preparedStatement.setObject(1,data);
			
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMenssage = "Se a presentado un problema inesperado tratando de llevar a cabo la eliminación de la información del Usuario. Por favor intente de nuevo, y si el problema persiste reporte la novedad...";
			var technicalMessage="Se a presentado un problema al tratar de eliminar la información del Usuario en la base de datos SQL Server. Por favor valide el log de errores para encontrar mayores detalles del problema presentado...";

			throw DataSdjException.crear(userMenssage, technicalMessage, exception);
		}
		
		
	}

}
