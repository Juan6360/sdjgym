package co.sdj.crosscutting.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public final class DateHelper {

    public static final String DEFAULT_DATE_STRING = "1970-01-01";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final Date DEFAULT_DATE;

    static {
        try {
            DEFAULT_DATE = DATE_FORMAT.parse(DEFAULT_DATE_STRING); 
        } catch (ParseException e) {
            throw new RuntimeException("Error initializing default date", e);
        }
    }
    
    public static java.sql.Date cambio(final Date utilDate) {
    	var sqlDate = new java.sql.Date(utilDate.getTime());
    	return sqlDate;
    }

    public static boolean isNull(final Date date) {
        return ObjectHelper.isNull(date);
    }

    public static Date getDefault(final Date date, final Date defaultDate) {
        return ObjectHelper.getDefault(date, defaultDate);
    }
    
    public static String getDateDefaultAsString () {
    	return DEFAULT_DATE_STRING;
    }
    
    public static final Date getDefault() {
		return convertToDate(DEFAULT_DATE_STRING);
	}

    public static Date convertToDate(final String date) {
        try {
        	return DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            return DEFAULT_DATE;
        }
    }

    public static boolean validateDateFormat(Date date) {
    	String dateString = DATE_FORMAT.format(date);
        try {
            DATE_FORMAT.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false; 
        }
    }
}


