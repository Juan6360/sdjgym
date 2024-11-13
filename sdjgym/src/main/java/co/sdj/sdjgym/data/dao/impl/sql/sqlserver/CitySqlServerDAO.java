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
import co.sdj.sdjgym.data.dao.impl.sql.SqlDAO;
import co.sdj.sdjgym.entity.CityEntity;


final class CitySqlServerDAO extends SqlDAO implements CityDAO {



	protected CitySqlServerDAO(final Connection connection) {
		super(connection);
	}

	

	@Override
	public CityEntity findByID(final UUID id) {
		var cityEntityFilter = new CityEntity();
		cityEntityFilter.setId(id);
		
		var result = findByFilter(cityEntityFilter);
		return (result.isEmpty())? new CityEntity() : result.get(0);
	}

	@Override
	public List<CityEntity> findAll() {
		return findByFilter(new CityEntity());
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filter) {
		final var statement = new  StringBuilder();
		final var parameters = new ArrayList<>();
		final var resultSelect = new ArrayList<CityEntity>();
		var statementWasPrepared = false;
		 
		
		createSelect(statement);
		createFrom(statement);
		createWhere(statement, filter, parameters);
		createOrderBy(statement);
		
		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())){
			
			for  (var arrayIndex = 0; arrayIndex < parameters.size(); arrayIndex++) {
				var statementIndex = arrayIndex + 1;
				preparedStatement.setObject(statementIndex, parameters.get(arrayIndex));
			}
			
			  statementWasPrepared = true;
			
			  final var result = preparedStatement.executeQuery(); 
							
			  while(result.next()) {
				var CityEntityTmp = new CityEntity();
				CityEntityTmp.setId(UUIDHelper.convertToUUID(result.getString("id")));
				CityEntityTmp.setName(result.getString("name"));
							
			    resultSelect.add(CityEntityTmp);
		    } 
			
								
		    }catch(final SQLException exception) 
		{
		
			var userMessage = "se ha presentado un problema tratando de llevar a cabo la consulta de las entidad de la ciudad en el filtro deseado. por favor intente de nuevo y si el problema persiste reporte la novedad....";
			var technicalMessage = "se ha presentado un problema a tratar de consultar la informacion de las ciudades del filtro deseado en la base de datos de SQL tratando de ejecutar la setencia SQL que se iba a ejectar .por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			
			if(statementWasPrepared) {
				technicalMessage = "se ha presentado un problema a tratar de consultar la informacion de las ciudades del filtro deseado en la base de datos de SQL tratando de ejecutar la setencia SQL Definida.por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
			}
			
		
			throw DataSdjException.crear(userMessage, technicalMessage, exception);
		 }
		
		return resultSelect;
	}
	private void createSelect(final StringBuilder statement) {
		statement.append("SELECT id, name ");
	}
	private void createFrom(final StringBuilder statement) {
		statement.append("FROM City ");
	}
	
	private void createWhere(final StringBuilder statement,
			final CityEntity filter,
			final List<Object> parameters) {
		
		if(!ObjectHelper.isNull(filter)) {
			
			if(!UUIDHelper.isDefault(filter.getId())) {
				statement.append("WHERE id = ?");
				parameters.add(filter.getId());
			}
			
			if(!TextHelper.isEmptyApplyingTrim(filter.getName())){
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

