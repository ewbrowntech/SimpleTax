import java.util.Arrays;

/**
 * User.java
 *
 * Simple user class
 *
 * @author   Ethan Brown (ewb0020@auburn.edu)
 * @version  21 NOV 21
 */
public class User {
	String username;
	String password;
	Boolean isAdmin;
	String income;
	String deductions;
	String taxableIncome;
	String balance;
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

	public void setIncome(String incomeIn) {
		this.income = incomeIn;
	}
	
	public String getIncome() {
		return this.income;
	}

	public void setDeductions(String deductionsIn) {
		this.deductions = deductionsIn;
	}
	
	public String getDeductions() {
		return this.deductions;
	}

	public void setTaxableIncome(String incomeIn) {
		this.taxableIncome = incomeIn;
	}
	
	public String getTaxableIncome() {
		return this.taxableIncome;
	}
	
	public void setBalance(String balanceIn) {
		this.balance = balanceIn;
	}
	
	public String getBalance() {
		return this.balance;
	}
	
	public void addMessage(int messageIn) {
		messages = Arrays.copyOf(messages, messages.length + 1);
		messages[messages.length - 1] = messageIn;
	}
	
	public int getMessageNumber() {
		return messages.length;
	}
}
