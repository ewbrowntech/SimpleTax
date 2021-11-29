import java.util.Arrays;

/**
 * User.java
 *
 * Simple user class
 *
 * @author   Ethan Brown (ewb0020@auburn.edu)
 * @version  21 NOV 21
 */
public class user {
	String username;
	String password;
	Boolean isAdmin;
	Double income;
	Double deductions;
	Double balance;
	int[] messages = new int[] {};


	public void setUsername(String usernameIn) {
		this.username = usernameIn;
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setPassword(String passwordIn) {
		this.password = passwordIn;
	}

	public void makeAdmin() {
		this.isAdmin = true;
	}

	public void makeNotAdmin() {
		this.isAdmin = false;
	}

	public void setIncome(Double incomeIn) {
		this.income = incomeIn;
	}

	public void setDeductions(Double deductionsIn) {
		this.deductions = deductionsIn;
	}

	public void setBalance(Double balanceIn) {
		this.balance = balanceIn;
	}
	
	public void addMessage(int messageIn) {
		messages = Arrays.copyOf(messages, messages.length + 1);
		messages[messages.length - 1] = messageIn;
	}
	
	public int getMessageNumber() {
		return messages.length;
	}
}
