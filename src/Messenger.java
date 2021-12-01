import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
	
	/*
	 * Driver for the messenger.
	 */
	public void messengerPrompt()
			throws java.io.IOException {  

		System.out.println("\nWelcome to the messenger. Please select from the options below.\n");
		System.out.println("[1] Draft a message\n[2] Check messages");
		// char choice = (char) System.in.read();
		char choice = 0;
		while (choice != 'Q') {
			Scanner input1 = new Scanner(System.in);
			choice = (char) System.in.read();
			if (choice == '1') {
				draftMessage();
			}
			else if (choice == 'Q') {
				break;
			}
			else {
				checkMessages();
			}
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
				System.out.println("\nEnter recipient: ");
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
			
			// Stores the message in messages.txt
			try
			    {
					File file = new File("messages.txt");
					BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
					writer.append(newMessage.getRecipient() + "\n");
					writer.append(newMessage.getID()); // Changes integer ID to string
					writer.append("\n" + newMessage.getTitle() + "\n");
					writer.append(newMessage.getBody() + "\n\n");
			        writer.flush();
			        writer.close();
			    }
			    catch(IOException ioException)
			    {
			        ioException.printStackTrace();
			    }

	}
	
	/*
	 * Parses messages accessible to active user and stored in messages.txt into a 
	 * list of message objects.
	 */
	public void checkMessages() throws IOException {
		//----------Temporary----------
		user activeUser = new user();
		activeUser.setUsername("Client1");
		//-----------------------------
		
		File file = new File("messages.txt");
	    Scanner fileScan = new Scanner(file);
	    List<message> messages = new ArrayList<message>();

	    while (fileScan.hasNextLine()) {
	    	String buffer = fileScan.nextLine(); // Avoid issue of skipping lines
	        if (buffer.equals(activeUser.getUsername())) { // Message to user found
	        	 message message1 = new message();
	             message1.setRecipient(buffer);
	             message1.setID(fileScan.nextLine());
	             message1.setTitle(fileScan.nextLine());
	             message1.setBody(fileScan.nextLine());
	             fileScan.nextLine();
	             
	             messages.add(message1);
	        }
	    }
	    int inbox = messages.size();
	    
	    /*
	     * Check messages assigned to account.
	     */
	    Scanner scan = new Scanner(System.in);
	    System.out.println("You have " + inbox + " messages:");
	    for (message message : messages) {
	        System.out.println(message.getID() + " - " + message.getTitle());
	    }
	    
	    boolean idHit = false;
	    while (idHit == false) {
		    System.out.println("\nEnter the ID of the message you wish to view or Q to exit:");
		    String input = scan.nextLine();
		    if (input.equals("Q")) {
		    	messengerPrompt(); 				// Go back to the messenger
		    }
		    else if (input.equals("\n")) {
		    	continue;						// No entry. Repeat the loop.
		    }
	    	for (message message : messages) {
	    		if (input.equals(message.getID())) {
	    			System.out.println("\n" + message.getTitle() + "\n\n" + message.getBody() + 
	    					"\n");
	    			break;
	    		}
	    	}
	    	checkMessages();
	    }
	}
}

class message {
	String recipient = "";
	String title = "";
	String body = "";
	String messageID;
		
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
		this.messageID = Integer.toString(ThreadLocalRandom.current().nextInt(1, 500 + 1));
	}
	
	public void setID(String idIn) {
		this.messageID = idIn;
	}
	
	public String getID() {
		return this.messageID;
	}
}
