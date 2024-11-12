package co.sdj.crosscutting.helpers;


public class TextHelper {
	
	public static final String EMPTY = "";
	public static final String ONLY_LETTERS_SPACES = "[A-Za-záÁéÉíÍóÓúÚñÑ]*";
	private static final String ONLY_NUMBERS = "[0-9]";
	private static final String EMAIL_PATTERN = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
	private static final String ADdRESS_PATTERN = "[a-zA-Z0-9-]";
	
	private TextHelper() {
		
	}
	
	public static final boolean patternIsValid(final String string, final String pattern) {
		return applyTrim(string).matches(concat("^", pattern, "$"));
	}
	
	public static boolean containsOnlyIntegers(final String string) {
        return patternIsValid(string, ONLY_NUMBERS);
    }
	
	public static boolean isValidEmail(final String string) {
        return patternIsValid(string, EMAIL_PATTERN);
    }
	public static boolean isValidAddress(final String string) {
		return patternIsValid(string, ADdRESS_PATTERN);
	}
	
	public static boolean containsOnlyLettersAndSpaces(final String string) {
		return patternIsValid(string, ONLY_LETTERS_SPACES);
	}
	
	public static String concat(final String...strings) {
		var sb = new StringBuilder(EMPTY);
		
		for (String string :strings) {
			sb.append(getDefault(string));
		}
		
		return sb.toString();
	}
	
	public static boolean isNull(final String string) {
		return ObjectHelper.isNull(string);
	}
	
	public static String getDefault(final String string, final String  defaultValue) {
		return ObjectHelper.getDefault(string, defaultValue);
	}
	
	public static String getDefault (final String string) {
		return getDefault(string, EMPTY) ;
		
	}
	
	public static boolean isEmpty(final String string) {
		return EMPTY.equals(getDefault(string));
		
	}
	
	public static boolean isEmptyApplyingTrim(final String string) {
		return isEmpty(applyTrim(string));
		
	}
	public static String applyTrim (final String string) {
		return getDefault(string).trim();
	}

	public static int len(final String string) {
		return applyTrim(string).length();
	}
	
	public static boolean lenIsValid(final String string, final int min, final int max) {
		return minLenIsValid(string, min) && maxLenIsvalid(string, max);
	}
	
	public static boolean minLenIsValid(final String string, final int min) {
		return NumericHelper.isGreatOrEqual(len(string), min);
	}
	
	public static boolean maxLenIsvalid(final String string, final int max) {
		return NumericHelper.isLessOrEqual(len(string), max);
	}
	
}
