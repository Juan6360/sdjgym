package co.sdj.sdjgym.businesslogic.usecase.user.rules.impl;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.UserAddressConsistencyIsValid;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;

public class UserAddressConsistencyIsValidImpl implements UserAddressConsistencyIsValid{

	@Override
	public void execute(String data) {
		validateNotNull(data);
		validateLen(data);
		validateFormat(data);
		
	}
	
	private void validateLen(final String data) {
		if(!TextHelper.maxLenIsvalid(data, 25)) {
			 var userMessage = data.toString()+" solo puede contener 25 caracteres";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
		
	}
	

	private void validateFormat(final String data) {
		if(!TextHelper.isValidAddress(data)) {
			 var userMessage =data.toString()+"solo puede contener letas y caracteres especiales";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
	}
	

	private void validateNotNull(final String data) {
		if(TextHelper.isEmpty(data)) {
			 var userMessage ="No hay una direccion ingresada, favor ingresarlo nuevamente. " + data.toString();
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
			
    }
		
}
