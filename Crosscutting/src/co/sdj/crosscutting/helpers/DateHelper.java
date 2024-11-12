package co.sdj.crosscutting.helpers;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateHelper {

    public static final String DEFAULT_DATE_STRING = "01/01/1970"; 
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public static final Date DEFAULT_DATE;

    static {
        try {
            DEFAULT_DATE = DATE_FORMAT.parse(DEFAULT_DATE_STRING); 
        } catch (ParseException e) {
            throw new RuntimeException("Error initializing default date", e);
        }
    }
    
    public static java.sql.Date cambio(final java.util.Date utilDate) {
    	java.sql.Date  sqlDate = new java.sql.Date(utilDate.getTime());
    	return sqlDate;
    }

    public static boolean isNull(final Date date) {
        return ObjectHelper.isNull(date);
    }

    public static Date getDefault(final Date date, final Date defaultDate) {
        return ObjectHelper.getDefault(date, defaultDate);
    }

    public static Date getDefault(final Date date) {
        return getDefault(date, DEFAULT_DATE);
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


