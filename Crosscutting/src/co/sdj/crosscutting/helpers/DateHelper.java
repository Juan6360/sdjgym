package co.sdj.crosscutting.helpers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	
	public static final String TITANIC = "19/12/1997";
	
	public static boolean isNull(final Date date) {
		return ObjectHelper.isNull(date);
	}
	
	public static Date getDefault(final Date date, final Date  defaultValue) {
		return ObjectHelper.getDefault(date, defaultValue);
	}
	
	
	public static Date getDefault (final Date date) throws ParseException {
		return getDefault(date, getDefault()) ;
		
	}
	
	public static Date getDefault() {
		try {
			return changeStringToDate(TITANIC);
		} catch (ParseException e) {
			e.printStackTrace();
			return new Date();
		}
		
	}
	
	// TODO hacerle las condiciones al changeStrinToDate
	public static Date changeStringToDate(String string) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date date= formato.parse(string) ;
		return date;
	}
	
	
	
}
