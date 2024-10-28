package co.sdj.sdjgym.crosscutting.exceptions;

import co.sdj.crosscutting.exceptions.enums.Layer;

public class DataSdjException extends SdjException {
 
	private static final long serialVersionUID = 1L;
 
	public DataSdjException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DATA);
	}
 
	public static final DataSdjException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DataSdjException(userMessage, technicalMessage, rootException);
	}
 
	public static final DataSdjException crear(final String userMessage) {
		return new DataSdjException(userMessage, userMessage, new Exception());
	}
 
	public static final DataSdjException crear(final String userMessage, final String technicalMessage) {
		return new DataSdjException(userMessage, technicalMessage, new Exception());
	}
 
}
 