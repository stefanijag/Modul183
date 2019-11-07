package modul.api.service.exception;

public class ModulException extends Exception{

	/**
	 * generated
	 */
	private static final long serialVersionUID = 4574907205686795828L;

	public ModulException(String message, Exception e) {
		super(message, e);
	}
	
	public ModulException(String message) {
		super(message);
	}
	
	
}
