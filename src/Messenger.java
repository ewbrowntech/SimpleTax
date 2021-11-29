import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Messenger.java 
 * 
 * Allows users to send and receive messages.
 *
 * @author   Ethan Brown (ewb0020@auburn.edu)
 * @version  29 NOV 21
 */
public class Messenger {
	
	public void messengerPrompt()
			throws java.io.IOException {

		Scanner input1 = new Scanner(System.in);   

		// reading a character   
		char choice = input1.next().charAt(0);   
		//prints the character   

		System.out.println("Welcome to the messenger. Please select from the options below.\n");
		System.out.println("[1] Draft a message\n");
		
		choice = (char) System.in.read();
		
		if (choice == '1') {
			draftMessage();
		}
		else {
		    System.exit(0);
		}
	}
	
	/*
	 * Allows for the creation and sending of a message.
	 */
	public void draftMessage()
			throws java.io.IOException {

			String messageInput;
			Scanner input2 = new Scanner(System.in);
			input2.nextLine();						// Clears input buffer, was causing first loop to repeat twice
			message newMessage = new message();
			Boolean userExists = false;

			do {
				messageInput = "";
				System.out.println("Enter recipient: ");
				messageInput = input2.nextLine();
				messageInput = messageInput.replaceAll("\\s", "");		// Clears all whitespace
				messageInput = messageInput.replace("\n", "");		// Clears newline
				if (messageInput == "") {
					System.out.println("No input detected. Please try again!");
				}
				else if (messageInput.equals("Q")) {
					break;
				}
			} while (messageInput == "");
			if (messageInput.equals("Q")) {
				messengerPrompt();
			}
			newMessage.setRecipient(messageInput);		// If user exists, message will be sent.
			
			do {
				System.out.println("Enter message title: ");
				messageInput = input2.nextLine();
				messageInput = messageInput.trim();		// Trims leading and trailing whitespace
				messageInput = messageInput.replaceAll("\n", "");
				if (messageInput == "") {
					System.out.println("No input detected. Please try again!");
				}
			} while (messageInput == "");
			newMessage.setTitle(messageInput);		
			
			do {
				System.out.println("Enter your message: ");
				messageInput = input2.nextLine();
				messageInput = messageInput.trim();		// Trims leading and trailing whitespace
				messageInput = messageInput.replaceAll("\n", "");
				if (messageInput == "") {
					System.out.println("No input detected. Please try again!");
				}
			} while (messageInput == "");
			newMessage.setBody(messageInput);
			newMessage.generateID();
			
			System.out.println("Test");
			try
			    {
					File file = new File("messages.txt");
		            file.createNewFile();
					BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
					writer.append(String.valueOf(newMessage.getID())); // Changes integer ID to string
					writer.append(newMessage.getRecipient() + "\n");
					writer.append(newMessage.getTitle() + "\n");
					writer.append(newMessage.getBody() + "\n\n");
			        writer.flush(); // empty buffer in the file
			        writer.close(); // close the file to allow opening by others applications
			    }
			    catch(IOException ioException)
			    {
			        ioException.printStackTrace();
			    }

	}

}

class message {
	String recipient = "";
	String title = "";
	String body = "";
	int messageID;
		
	public void setRecipient(String recipientIn) {
		this.recipient = recipientIn;
	}
	
	public String getRecipient() {
		return this.recipient;
	}
	
	public void setTitle(String titleIn) {
		this.title = titleIn;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setBody(String bodyIn) {
		this.body = bodyIn;
	}
	
	public String getBody() {
		return this.body;
	}
	
	public void generateID() {
		this.messageID = ThreadLocalRandom.current().nextInt(1, 500 + 1);
	}
	
	public int getID() {
		return this.messageID;
	}
}
