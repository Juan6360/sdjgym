package co.sdj.sdjgym.crosscutting.exceptions;

import co.sdj.crosscutting.exceptions.enums.Layer;

public class DomainSdjException extends SdjException{

	public DomainSdjException(String userMessage, String technicalMessage, Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DOMAIN);
		// TODO Auto-generated constructor stub
	}
	
	public static final DomainSdjException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DomainSdjException(userMessage, technicalMessage, rootException);
	}

	public static final DomainSdjException crear(final String userMessage) {
		return new DomainSdjException(userMessage, userMessage, new Exception());
	}

	public static final DomainSdjException crear(final String userMessage, final String technicalMessage) {
		return new DomainSdjException(userMessage, technicalMessage, new Exception());
	}
	
}
