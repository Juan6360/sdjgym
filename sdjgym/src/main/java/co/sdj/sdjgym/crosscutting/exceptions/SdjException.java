package co.sdj.sdjgym.crosscutting.exceptions;

import co.sdj.crosscutting.exceptions.SdjApplicationException;
import co.sdj.crosscutting.exceptions.enums.Layer;
 
public class SdjException extends SdjApplicationException {
 
	private static final long serialVersionUID = 1L;
 
	public SdjException(final String userMessage, final String technicalMessage, final Exception rootException,
			final Layer layer) {
		super(userMessage, technicalMessage, rootException, layer);
	}
 
	public static SdjException crear(final String userMessage, final String technicalMessage,
			final Exception rootException, final Layer layer) {
		return new SdjException(userMessage, technicalMessage, rootException, layer);
	}
 
	public static SdjException crear(final String userMessage) {
		return new SdjException(userMessage, userMessage, new Exception(), Layer.GENERAL);
	}
 
	public static SdjException crear(final String userMessage, final String technicalMessage) {
		return new SdjException(userMessage, technicalMessage, new Exception(), Layer.GENERAL);
	}
 
}
