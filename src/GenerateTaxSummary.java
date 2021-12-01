import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * GenerateTaxSummary.java 
 * 
 * Allows for the instantiation of an active user.
 *
 * @author   Ethan Brown (ewb0020@auburn.edu)
 * @version  01 DEC 21
 */
public class GenerateTaxSummary {
	User activeUser = new User();
	
	/*
	 * Generates the summary file
	 */
	public void generateFile() throws IOException {
		loadUser();
		
		try {
			new FileWriter("TaxSummary.txt", false).close();		// Deletes the contents of TaxSummary.txt
			File activeFile = new File("TaxSummary.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(activeFile, true));
			writer.append("Username: " + activeUser.getUsername() + "\n");
			writer.append("Income: $" + activeUser.getIncome() + "\n");
			writer.append("Deductions: $" + activeUser.getDeductions() + "\n");
			writer.append("Balance: $" + activeUser.getBalance() + "\n");
			writer.flush();
			writer.close();
		} catch(IOException ioException) {
			ioException.printStackTrace();
		}
		
		System.out.println("Tax Summary Generated!\n");
	}
	
	/*
	 * Loads in the active user's details
	 */
	public void loadUser() throws FileNotFoundException {
		File file = new File("activeuser.txt");
		Scanner fileScan = new Scanner(file);
		String username = fileScan.nextLine();
		username = username.replace("\n", "");		// Clears newline
		activeUser.setUsername(username);
		activeUser.setIncome(fileScan.nextLine());
		activeUser.setDeductions(fileScan.nextLine());
		activeUser.setBalance(fileScan.nextLine());
		fileScan.close();
	}

}
