package co.sdj.sdjgym.crosscutting.exceptions;

import co.sdj.crosscutting.exceptions.enums.Layer;

public class DTOSdjException extends SdjException {

	private static final long serialVersionUID = 1L;

	public DTOSdjException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DTO);
	}

	public static final DTOSdjException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DTOSdjException(userMessage, technicalMessage, rootException);
	}

	public static final DTOSdjException crear(final String userMessage) {
		return new DTOSdjException(userMessage, userMessage, new Exception());
	}

	public static final DTOSdjException crear(final String userMessage, final String technicalMessage) {
		return new DTOSdjException(userMessage, technicalMessage, new Exception());
	}

}
