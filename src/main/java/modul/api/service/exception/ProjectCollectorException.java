package modul.api.service.exception;

/**
 * 
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov
 * @version 1.1
 */
public class ProjectCollectorException extends Exception{

	/**
	 * generated
	 */
	private static final long serialVersionUID = 4574907205686795828L;

	public ProjectCollectorException(String message, Exception e) {
		super(message, e);
	}
	
	public ProjectCollectorException(String message) {
		super(message);
	}
	
	
}
