import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * SimpleTax.java 
 * 
 * SimpleTax program. Simple application for filing of taxes.
 *
 * @author   Ethan Brown (ewb0020@auburn.edu)
 * @version  01 DEC 21
 */

public class SimpleTax {
	
	public static void main(String[] args) 
			throws java.io.IOException {
		
			Login login = new Login();
			login.loginPrompt();
			
			System.out.println("Welcome to SimpleTax!\n");
		    HomeScreen h = new HomeScreen();
		    h.welcomePrompt();		// Calls up the homescreen, with its options
		    System.exit(0);
	}
}
