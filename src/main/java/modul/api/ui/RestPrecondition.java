package modul.api.ui;

public class RestPrecondition {

	    public static <T> T checkFound(T resource) throws Exception {
	        if (resource == null) {
	            throw new Exception();
	        }
	        return resource;
	    }
}
