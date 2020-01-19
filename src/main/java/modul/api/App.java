package modul.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * to start the application
 * 
 * M183: Project collector
 * 
 * @author Stefanija Gojkovic
 * @version 1.1
 */
@SpringBootApplication(scanBasePackages="modul.api")
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
        System.out.println( "Hello World!" );
    }
}
