package co.sdj.sdjgym.data.dao.impl.sql.sqlserver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.crosscutting.exceptions.DataSdjException;
import co.sdj.sdjgym.entity.IdentificationTypeEntity;

public class DatabaseExample {
	
    public static void main(String[] args) {
    	public List<IdentificationTypeEntity> findByFilter(final IdentificationTypeEntity filter) {
    		final var statement = new  StringBuilder();
    		final var parameters = new ArrayList<>();
    		final var resultSelect = new ArrayList<IdentificationTypeEntity>();
    		var statementWasPrepared = false;
    		 
    		
    		createSelect(statement);
    		createFrom(statement);
    		createWhere(statement, filter, parameters);
    		
    		try (final var preparedStatement = getConnection().prepareStatement(statement.toString())){
    			
    			for  (var arrayIndex = 0; arrayIndex < parameters.size(); arrayIndex++) {
    				var statementIndex = arrayIndex + 1;
    				preparedStatement.setObject(statementIndex, parameters.get(arrayIndex));
    			}
    			
    			  statementWasPrepared = true;
    			
    			  final var result = preparedStatement.executeQuery(); 
    							
    			  while(result.next()) {
    				var IdentificationTypeEntityTmp = new IdentificationTypeEntity();
    				IdentificationTypeEntityTmp.setId(UUIDHelper.convertToUUID(result.getString("id")));
    				IdentificationTypeEntityTmp.setName(result.getString("name"));
    							
    			    resultSelect.add(IdentificationTypeEntityTmp);
    		    } 
    			
    								
    		    }catch(final SQLException exception) 
    		{
    		
    			var userMessage = "se ha presentado un problema tratando de llevar a cabo la consulta de las entidad del tipo de identificación en el filtro deseado. por favor intente de nuevo y si el problema persiste reporte la novedad....";
    			var technicalMessage = "se ha presentado un problema a tratar de consultar la informacion de los tipos de identificacion del filtro deseado en la base de datos de SQL tratando de ejecutar la setencia SQL que se iba a ejectar .por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
    			
    			if(statementWasPrepared) {
    				technicalMessage = "se ha presentado un problema a tratar de consultar la informacion de los tipos de identificacion del filtro deseado en la base de datos de SQL tratando de ejecutar la setencia SQL Definida.por favor valide el log de errores para encontrar mayores detalles del problema presentado...";
    			}
    			
    		
    			throw DataSdjException.crear(userMessage, technicalMessage, exception);
    		 }
    		
    		return resultSelect;
    	}
    	private void createSelect(final StringBuilder statement) {
    		statement.append("SELECT id, name ");
    	}
    	private void createFrom(final StringBuilder statement) {
    		statement.append("FROM IdentificationType ");
    	}
    	
    	private void createWhere(final StringBuilder statement,
    			final IdentificationTypeEntity filter,
    			final List<Object> parameters) {
    		
    		if(!ObjectHelper.isNull(filter)) {
    			
    			if(UUIDHelper.isDefault(filter.getId())) {
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
}