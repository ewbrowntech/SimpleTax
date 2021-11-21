import java.nio.file.FileSystemNotFoundException;
import java.util.Scanner;

/**
 * HomeScreen.Java
 * 
 * Runs the home screen of the program
 *
 * @author   Ethan Brown (ewb0020@auburn.edu)
 * @version  21 NOV 21
 */

public class HomeScreen {
	
	public void welcomePrompt()
			throws java.io.IOException {
			
			String termIn = "";
			Scanner input = new Scanner(System.in);
		
			// Welcome and options screen
			String option1 = "1";
			String option2 = "2";
			System.out.println("Welcome to SimpleTax!\n\n Please select "
					+ "from the options below.\n");
			System.out.println("[1] Go to messenger\n"			// Additional functionality to be added
							 + "[2] Generate tax summary\n");	// as we code more features
			termIn = input.nextLine();
			termIn = termIn.trim();					// Trims leading and trailing whitespace
			
			if (input.equals(option1)) {
				System.exit(0);
			}
			if (input.equals(option2)) {
				System.exit(0);
			}
			else {
				this.welcomePrompt();
			}
		}

}
