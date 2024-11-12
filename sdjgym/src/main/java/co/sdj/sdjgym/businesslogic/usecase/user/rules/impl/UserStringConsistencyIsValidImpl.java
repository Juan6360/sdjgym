package co.sdj.sdjgym.businesslogic.usecase.user.rules.impl;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.UserStringConsistencyIsValid;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;

public class UserStringConsistencyIsValidImpl implements  UserStringConsistencyIsValid{

	@Override
	public void execute(String data) {
		validateNotNull(data);
		validateLen(data);
		validateFormat(data);
		
	}
	
	private void validateLen(final String data) {
		if(!TextHelper.maxLenIsvalid(data, 50)) {
			 var userMessage = data.toString()+" solo puede contener 50 caracteres";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
		
	}
	

	private void validateFormat(final String data) {
		if(!TextHelper.containsOnlyLettersAndSpaces(data)) {
			 var userMessage =data.toString()+"solo puede contener letas y espacios";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
	}
	

	private void validateNotNull(final String data) {
		if(TextHelper.isEmpty(data)) {
			 var userMessage ="el dato ingresado está vacio, favor ingresarlo nuevamente. " + data.toString();
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
			
    }

}
