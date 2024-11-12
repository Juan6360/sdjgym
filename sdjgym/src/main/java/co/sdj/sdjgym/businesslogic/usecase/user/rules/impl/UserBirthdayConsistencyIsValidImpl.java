package co.sdj.sdjgym.businesslogic.usecase.user.rules.impl;

import co.sdj.crosscutting.helpers.DateHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.UserBirthdayConsistencyIsValid;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;

public class UserBirthdayConsistencyIsValidImpl implements UserBirthdayConsistencyIsValid{

	@Override
	public void execute(String data) {
		validateNotNull(data);
		validateFormat(data);
		
	}
	
	

	private void validateFormat(final String data) {
		if(!DateHelper.validateDateFormat(data)) {
			 var userMessage =data.toString()+"solo puede contener letas y espacios";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
	}
	

	private void validateNotNull(final String data) {
		if(TextHelper.isEmpty(data)) {
			 var userMessage ="No se a presentado una fecha de nacimiento, favor ingresarla nuuevamente...";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
			
    }
	
}
