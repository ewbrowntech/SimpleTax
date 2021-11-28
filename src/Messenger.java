import java.util.Scanner;

/**
 * Messenger.java 
 * 
 * Allows users to send and receive messages.
 *
 * @author   Ethan Brown (ewb0020@auburn.edu)
 * @version  28 NOV 21
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
	
	public void setTitle(String titleIn) {
		this.title = titleIn;
	}
	
	public void setBody(String bodyIn) {
		this.body = bodyIn;
	}
}
