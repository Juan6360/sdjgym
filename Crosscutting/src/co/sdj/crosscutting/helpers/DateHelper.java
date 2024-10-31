package co.sdj.crosscutting.helpers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	
	
	public static boolean isNull(final Date date) {
		return ObjectHelper.isNull(date);
	}
	
	public static Date getDefault(final Date date, final Date  defaultValue) {
		return ObjectHelper.getDefault(date, defaultValue);
	}
	
	
	public static Date getDefault (final Date date) throws ParseException {
		return getDefault(date, getDefault()) ;
		
	}
	
	public static Date getDefault() throws ParseException{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formato.parse("00-00-0000") ;
		return date;
	}
	
	// TODO hacerle las condiciones al changeStrinToDate
	public static Date changeStringToDate(String string) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date date= formato.parse(string) ;
		return date;
	}
	
	
	
}
