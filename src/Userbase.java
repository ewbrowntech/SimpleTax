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
	
	public user[] ub = new user[] {};
	
	public void addUser(user userIn) {
		ub = Arrays.copyOf(ub, ub.length + 1);
		ub[ub.length - 1] = userIn;
	}
	
	public void makeUsers() {				// Instantiate a few users
		
		// Active user
		user activeUser = new user();
		
		// Client 1
		user client1 = new user();
		client1.setUsername("Client1");
		client1.setPassword("password");
		client1.makeNotAdmin();
		addUser(client1);
		
		// Client 2
		user client2 = new user();
		client2.setUsername("Client2");
		client2.setPassword("password");
		client1.makeNotAdmin();
		addUser(client2);
		
		// Admin
		user admin = new user();
		admin.setUsername("Admin");
		admin.setPassword("password");
		admin.makeAdmin();
		addUser(admin);
	}
	
}
