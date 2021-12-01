import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Login.java 
 * 
 * Allows for the instantiation of an active user.
 *
 * @author   Ethan Brown (ewb0020@auburn.edu)
 * @version  01 DEC 21
 */
public class Login {
	
	public void loginPrompt() throws FileNotFoundException {
		
		User activeUser = new User();
		
		String username;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your username:");
		username = input.nextLine();
		username = username.replaceAll("\\s", "");		// Clears all whitespace
		username = username.replace("\n", "");		// Clears newline
		if (username.equals("")) {
			loginPrompt();
		}

			
		File file = new File("users.txt");
		Scanner fileScan = new Scanner(file);

		boolean userExists = false;
		while (fileScan.hasNextLine()) {
		    String buffer = fileScan.nextLine(); // Avoid issue of skipping lines
		    if (buffer.equals(username)) {
		    	userExists = true;
		    	activeUser.setUsername(username);
		    	activeUser.setPassword(fileScan.nextLine());
		        activeUser.setIncome(fileScan.nextLine());
		        activeUser.setDeductions(fileScan.nextLine());
		        activeUser.setBalance(fileScan.nextLine());
		     }
		}
		if (userExists == false) {
			System.out.println("Invalid username. Please try again.");
			loginPrompt();
		}
		else {
			try {
				new FileWriter("activeuser.txt", false).close();		// Deletes the contents of activeuser.txt
				File activeFile = new File("activeuser.txt");
				BufferedWriter writer = new BufferedWriter(new FileWriter(activeFile, true));
				writer.append(activeUser.getUsername() + "\n");
				writer.append(activeUser.getIncome() + "\n");
				writer.append(activeUser.getDeductions() + "\n");
				writer.append(activeUser.getBalance() + "\n");
				writer.flush();
				writer.close();
			} catch(IOException ioException) {
				ioException.printStackTrace();
			}
			
		}
	}
}
