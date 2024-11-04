package co.sdj.crosscutting.helpers;



public final class NumericHelper {

	public static final int ZERO = 0;
	
	public static int getDefault(final int number, final int defaultValue) {
		return ObjectHelper.getDefault(number, defaultValue);
	}
	
	public static int getDefault(final int number) {
		return getDefault(number,ZERO);
	}
	
	public static final <T extends Number> boolean isGreat(final T numberOne, final T numberTwo) {
		return numberOne.doubleValue() > numberTwo.doubleValue();
	}

	public static final <T extends Number> boolean isLess(final T numberOne, final T numberTwo) {
		return numberOne.doubleValue() < numberTwo.doubleValue();
	}

	public static final <T extends Number> boolean isDifferent(final T numberOne, final T numberTwo) {
		return numberOne.doubleValue() != numberTwo.doubleValue();
	}

	public static final <T extends Number> boolean isEqual(final T numberOne, final T numberTwo) {
		return numberOne.doubleValue() == numberTwo.doubleValue();
	}

	public static final <T extends Number> boolean isGreatOrEqual(final T numberOne, final T numberTwo) {
		return numberOne.doubleValue() >= numberTwo.doubleValue();
	}

	public static final <T extends Number> boolean isLessOrEqual(final T numberOne, final T numberTwo) {
		return numberOne.doubleValue() <= numberTwo.doubleValue();
	}

	public static final <T extends Number> boolean isBetween(final T number, final T initialLimit, final T finalLimit,
			final boolean includeInitialLimit, final boolean includeFinalLimit) {
		return (includeInitialLimit ? isGreatOrEqual(number, initialLimit) : isGreat(number, initialLimit))
				&& (includeFinalLimit ? isLessOrEqual(number, finalLimit) : isLess(number, finalLimit));
	}
}
