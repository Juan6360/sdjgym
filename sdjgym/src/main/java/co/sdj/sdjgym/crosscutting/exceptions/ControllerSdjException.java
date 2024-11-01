package co.sdj.sdjgym.crosscutting.exceptions;

import co.sdj.crosscutting.exceptions.enums.Layer;

public class ControllerSdjException extends SdjException {

	private static final long serialVersionUID = 1L;

	public ControllerSdjException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.CONTROLLER);
	}

	public static final ControllerSdjException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new ControllerSdjException(userMessage, technicalMessage, rootException);
	}

	public static final ControllerSdjException crear(final String userMessage) {
		return new ControllerSdjException(userMessage, userMessage, new Exception());
	}

	public static final ControllerSdjException crear(final String userMessage, final String technicalMessage) {
		return new ControllerSdjException(userMessage, technicalMessage, new Exception());
	}

}
