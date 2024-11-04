package co.sdj.crosscutting.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    private static final String TITANIC = "19/12/1997";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final Date DEFAULT_DATE;

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

    public static Date changeStringToDate(String string) throws ParseException {
        return DATE_FORMAT.parse(string);
    }
}

