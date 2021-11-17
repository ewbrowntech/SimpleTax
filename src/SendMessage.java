import java.util.Scanner;

/**
 * SendMessage.java 
 * 
 * Allows for the formatting and sending of a message.
 * Edit this for robustness.
 *
 * @author   Ethan Brown (ewb0020@auburn.edu)
 * @version  17 NOV 21
 */
public class SendMessage {
	
	public void draftMessage()
			throws java.io.IOException {
		
			String messageInput = "";
			Scanner input = new Scanner(System.in);
			
			message newMessage = new message();
			Boolean userExists = false;
			while (!userExists) {
				System.out.println("Enter recipient: ");
				messageInput = input.nextLine();
				messageInput = messageInput.replaceAll("\\s", "");
			
				for(int i = 0; i < reservedUsernames.length; i++) { // To be added in main class
					if(messageInput = reservedUsernames[i]) {
						userExists = true;
						break;
					}
					else {
						System.out.println("\nSpecified user does not exist. Please try again.\n");
					}
				}
			}
			newMessage.setRecipient(messageInput);	// If user exists, message will be sent.
			
			System.out.println("Enter message title: ");
			messageInput = input.nextLine();
			messageInput = messageInput.trim();		// Trims leading and trailing whitespace
			newMessage.setTitle(messageInput);		
			
			System.out.println("Enter your message: ");
			messageInput = input.nextLine();
			messageInput = messageInput.trim();
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
