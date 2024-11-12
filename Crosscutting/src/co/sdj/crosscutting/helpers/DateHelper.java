package co.sdj.crosscutting.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateHelper {

    public static final String TITANIC = "19/12/1997";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public static final Date DEFAULT_DATE;

    static {
        try {
            DEFAULT_DATE = DATE_FORMAT.parse(TITANIC);
        } catch (ParseException e) {
            throw new RuntimeException("Error initializing default date", e);
        }
    }

    public static boolean isNull(final Date date) {
        return ObjectHelper.isNull(date);
    }

    public static Date getDefault(final Date date, final Date defaultValue) {
        return ObjectHelper.getDefault(date, defaultValue);
    }

    public static Date getDefault(final Date date) {
        return getDefault(date, DEFAULT_DATE);
    }

    public static boolean validateDateFormat(String string){
    	try {
    		DATE_FORMAT.parse(string);
    		return true;
        } catch (ParseException e) {
            throw new RuntimeException("Error initializing default date", e);
        }
        
    }
    
    
}

