import java.util.Scanner;
/**
 * HomeScreen.Java
 * 
 * Runs the home screen of the program
 *
 * @author   Ethan Brown (ewb0020@auburn.edu)
 * @version  28 NOV 21
 */

public class HomeScreen {
	
	public void welcomePrompt()
			throws java.io.IOException {
			
			char choice;
		
			// Welcome and options screen
			System.out.println("Please select from the options below.\n");
			System.out.println("[1] Go to messenger\n"			// Additional functionality to be added
							 + "[2] Generate tax summary\n");	// as we code more features
			Scanner input = new Scanner(System.in);
	        choice = input.next().charAt(0);
			
			if (choice == '1') {
				Messenger messenger = new Messenger();
				messenger.messengerPrompt();
			}
			if (choice == '2') {
				System.exit(0);						// Generate tax summary
			}
			else {
				System.out.println("Please try again!");
				this.welcomePrompt();
			}
		}

}
