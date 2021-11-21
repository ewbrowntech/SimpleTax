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
			
			char input;
		
			// Welcome and options screen
			System.out.println("Please select from the options below.\n");
			System.out.println("[1] Go to messenger\n"			// Additional functionality to be added
							 + "[2] Generate tax summary\n");	// as we code more features
			input = (char) System.in.read();
			
			if (input == '1') {
				System.exit(0);						// Go to messenger
			}
			if (input == '2') {
				System.exit(0);						// Generate tax summary
			}
			else {
				System.out.println("Please try again!");
				this.welcomePrompt();
			}
		}

}
