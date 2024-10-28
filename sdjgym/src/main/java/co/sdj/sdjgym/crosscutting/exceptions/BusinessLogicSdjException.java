package co.sdj.sdjgym.crosscutting.exceptions;

import co.sdj.crosscutting.exceptions.enums.Layer;

public class BusinessLogicSdjException extends SdjException {

	private static final long serialVersionUID = 1L;

	public BusinessLogicSdjException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.BUSINESSLOGIC);
	}

	public static final BusinessLogicSdjException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new BusinessLogicSdjException(userMessage, technicalMessage, rootException);
	}

	public static final BusinessLogicSdjException crear(final String userMessage) {
		return new BusinessLogicSdjException(userMessage, userMessage, new Exception());
	}

	public static final BusinessLogicSdjException crear(final String userMessage, final String technicalMessage) {
		return new BusinessLogicSdjException(userMessage, technicalMessage, new Exception());
	}

}
