import java.util.Arrays;

/**
 * Userbase.java
 *
 * Simple user class
 *
 * @author   Ethan Brown (ewb0020@auburn.edu)
 * @version  21 NOV 21
 */
public class Userbase {
	
	String[] reservedUsernames = new String[] {};
	
	public static String[] getUsernames() {
		return reservedUsernames;
	}
	
	public static Boolean userExists(String username) {
		for(int i = 0; i < reservedUsernames.length; i++) { // To be added in main class
			if(messageInput.equals(reservedUsernames[i])) {
				return true;
			}
			else {
				return fase;
			}
		}
	}
	
	public void reserveUsername(String username) {
		reservedUsernames = Arrays.copyOf(reservedUsernames, reservedUsernames.length + 1);
		reservedUsernames[reservedUsernames.length - 1] = username;
	}
	
	public void makeUsers() {				// Instantiate a few users
		
		// Client 1
		user client1 = new user();
		client1.setUsername("Client1");
		reserveUsername("Client1");
		client1.setPassword("password");
		client1.makeNotAdmin();
		
		// Client 2
		user client2 = new user();
		client2.setUsername("Client2");
		reserveUsername("Client2");
		client2.setPassword("password");
		client1.makeNotAdmin();
		
		// Admin
		user admin = new user();
		admin.setUsername("Admin");
		reserveUsername("Admin");
		admin.setPassword("password");
		admin.makeAdmin();
	}
	
}
