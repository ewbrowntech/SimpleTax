import java.util.Scanner;
/**
 * HomeScreen.Java
 * 
 * Runs the home screen of the program
 *
 * @author   Ethan Brown (ewb0020@auburn.edu)
 * @version  01 DEC 21
 */

public class HomeScreen {
	
	public void welcomePrompt()
			throws java.io.IOException {
					
			// Welcome and options screen
			System.out.println("Please select from the options below.");
			System.out.println("[1] Go to messenger\n"			// Additional functionality to be added
						+ "[2] Generate tax summary");	// as we code more features
			
	        while(true) {
	        	char choice = '0';
	        	Scanner input = new Scanner(System.in);
		        choice = input.next().charAt(0);
	        	if (choice == '1') {
					Messenger messenger = new Messenger();
					messenger.messengerPrompt();
				}
				else if (choice == '2') {
					GenerateTaxSummary g = new GenerateTaxSummary();
					g.generateFile();
					welcomePrompt();
				}
				else if (choice == 'Q') {
					break;
				}
				else {
					System.out.println("Please try again!");
					welcomePrompt();
				}
	        }
	}
}
