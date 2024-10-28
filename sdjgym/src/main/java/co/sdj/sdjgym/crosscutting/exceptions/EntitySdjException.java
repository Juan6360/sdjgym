package co.sdj.sdjgym.crosscutting.exceptions;

import co.sdj.crosscutting.exceptions.enums.Layer;

public class EntitySdjException extends SdjException {

	private static final long serialVersionUID = 1L;

	public EntitySdjException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.ENTITY);
	}

	public static final EntitySdjException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new EntitySdjException(userMessage, technicalMessage, rootException);
	}

	public static final EntitySdjException crear(final String userMessage) {
		return new EntitySdjException(userMessage, userMessage, new Exception());
	}

	public static final EntitySdjException crear(final String userMessage, final String technicalMessage) {
		return new EntitySdjException(userMessage, technicalMessage, new Exception());
	}

}
