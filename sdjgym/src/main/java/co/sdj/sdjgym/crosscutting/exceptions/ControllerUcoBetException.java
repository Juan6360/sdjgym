package co.sdj.sdjgym.crosscutting.exceptions;

import co.sdj.crosscutting.exceptions.enums.Layer;

public class ControllerUcoBetException extends SdjException {

	private static final long serialVersionUID = 1L;

	public ControllerUcoBetException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.CONTROLLER);
	}

	public static final ControllerUcoBetException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new ControllerUcoBetException(userMessage, technicalMessage, rootException);
	}

	public static final ControllerUcoBetException crear(final String userMessage) {
		return new ControllerUcoBetException(userMessage, userMessage, new Exception());
	}

	public static final ControllerUcoBetException crear(final String userMessage, final String technicalMessage) {
		return new ControllerUcoBetException(userMessage, technicalMessage, new Exception());
	}

}