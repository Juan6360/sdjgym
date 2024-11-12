package co.sdj.sdjgym.businesslogic.usecase.user.rules.impl;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.UserNumberConsistencyIsValid;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;

public class UserNumberConsistencyIsValidImpl implements UserNumberConsistencyIsValid{

	@Override
	public void execute(String data) {
		validateNotNull(data);
		validateLen(data);
		validateFormat(data);
		
	}
	
	
	private void validateLen(final String data) {
		if(!TextHelper.maxLenIsvalid(data, 10)) {
			 var userMessage = data.toString()+" solo puede contener 10 caracteres";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
		
	}
	

	private void validateFormat(final String data) {
		if(!TextHelper.containsOnlyIntegers(data)) {
			 var userMessage =data.toString()+"solo puede contener números";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
	}
	

	private void validateNotNull(final String data) {
		if(TextHelper.isEmpty(data)) {
			 var userMessage ="el dato ingresado está vacio, favor ingresarlo nuevamente...";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
			
    }

}
