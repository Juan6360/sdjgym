package co.sdj.sdjgym.businesslogic.usecase.user.rules.impl;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.UserEmailConsistencyIsValid;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;

public class UserEmailConsistencyIsValidImpl implements UserEmailConsistencyIsValid{

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
			 var userMessage ="No se a presentado un correo electronico, favor ingresarlo nuevamente...";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
			
    }
	
	
	

}
