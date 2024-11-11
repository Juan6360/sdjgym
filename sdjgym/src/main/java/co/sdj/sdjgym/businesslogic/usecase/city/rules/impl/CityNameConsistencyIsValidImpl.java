package co.sdj.sdjgym.businesslogic.usecase.city.rules.impl;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.sdjgym.businesslogic.usecase.RuleWithFactory;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;
import co.sdj.sdjgym.data.dao.DAOFactory;
import co.sdj.sdjgym.domain.CityDomain;

public class CityNameConsistencyIsValidImpl implements RuleWithFactory<CityDomain>{

	@Override
	public void execute(String data) {
		validateNotNull(data);
		validateLen(data);
		validateFormat(data);
		
		
	}
	
	private void validateLen(final String data) {
		if(!TextHelper.maxLenIsvalid(data, 50)) {
			 var userMessage ="el nombre de la cuidad puede contener 50 caracteres";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
		
	}
	

	private void validateFormat(final String data) {
		if(!TextHelper.containsOnlyLettersAndSpaces(data)) {
			 var userMessage ="el nombre de la cuidad solo puede contener letas y espacios";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
	}
	

	private void validateNotNull(final String data) {
		if(TextHelper.isEmpty(data)) {
			 var userMessage ="no existe un departamento con el identificador " + data.toString();
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
			
    }

}
