package co.sdj.sdjgym.businesslogic.usecase.user.rules.impl;

import java.util.Date;

import co.sdj.crosscutting.helpers.DateHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.sdjgym.businesslogic.usecase.user.rules.UserBirthdayConsistencyIsValid;
import co.sdj.sdjgym.crosscutting.exceptions.BusinessLogicSdjException;

public class UserBirthdayConsistencyIsValidImpl implements UserBirthdayConsistencyIsValid{

	@Override
	public void execute(Date data) {
		validateNotNull(data);
		validateFormat(data);
		
	}
	
	

	private void validateFormat(final Date data) {
		if(!DateHelper.validateDateFormat(data)) {
			 var userMessage =data.toString()+"no está en el formató indicado el formato es: dd/mm/aaaa";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
	}
	

	private void validateNotNull(final Date data) {
		if(DateHelper.isNull(data)) {
			 var userMessage ="No se a presentado una fecha de nacimiento, favor ingresarla nuevamente...";
			 throw BusinessLogicSdjException.crear(userMessage); 
		 }
			
    }
	
}
