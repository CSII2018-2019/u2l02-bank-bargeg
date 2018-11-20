import java.text.NumberFormat;

import javax.swing.JOptionPane;

public class BankAccount {
	// ● Current Balance
	//● Lowest balance allowable (example: the account holder would like to be notified when the balance goes below
	//$100)
	//It should contain the following methods:
	//● Constructor - takes all three fields as arguments
	//● Constructor - takes first two fields as arguments and defaults lowest balance to $100
	//● All setters and getters with appropriate restrictions
	//○ The setter for lowest balance allowable should ensure the value is positive
	//○ The setter for balance should be private (they will be using deposit and withdrawal)
	//● Methods for deposit and withdrawal
	//○ When withdrawing, the method should check if it will go below the allowable balance and ask “are you sure?”
	//● toString method that returns a string: Lombardi’s
	
	public String name; 
	private double accountBalance;
	private double lowestBalance; 
	//private double withdraw;
	//private double deposit; 
	
	public BankAccount (String n, double a, double l) {
		name = n;
		setBalance(a); 
		setLowest(l);
		
		
	}
	public BankAccount (String n, double a) {
		name = n;
		setBalance(a);
		lowestBalance = 100; 
	}
	
	
	public void setBalance (double a) {
		if (a >= 0) {
			accountBalance = a; 
		}
		else {
			accountBalance = 10000;
			System.out.println("Your account balance can't be negative! Defaulting to $1000");
		}
		
	}
	public void setLowest (double l) {
		if (l >= 0) {
			lowestBalance = l;
		}
		else {
			lowestBalance = 100;
			System.out.println("Lowest balance can't be negative, defaulting to $100");
		}
	}
	public void setDeposit (double amount) {
		accountBalance += amount;
	}
	public void setWithdrawal (double amount) {
		double tempBalance = accountBalance; 
		accountBalance -= amount;
		if (accountBalance < lowestBalance) {
			String input1 = JOptionPane.showInputDialog("Are you sure? This goes past your lowest allowable balance? (true or false)");
			boolean input = Boolean.parseBoolean(input1);
			if (input == true) {
				accountBalance = accountBalance; 
				}
			else if (input == false) {
				accountBalance = tempBalance;
			}
			else {
				System.out.println("That is not an answer- defaulting to no");
				accountBalance = tempBalance; 
			}
			
		}
		
		
		
	}
	public double getAccountBalance () {
		return accountBalance; 
	}
	public double getLowestBalance () {
		return lowestBalance; 
	}
	public double getWithdraw () {
		return accountBalance;
	}
	public double getDeposit () {
		return accountBalance; 
	}
	//NumberFormat formatter = NumberFormat.getCurrencyInstance();
	//String accountString = formatter.format(accountBalance);
	//String lowestString = formatter.format(lowestBalance);
	
	
	public String toString() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String accountString = formatter.format(accountBalance);
		String lowestString = formatter.format(lowestBalance);
		return name + "'s account holds " + accountString + 
				" with the lowest allowable amount of " + lowestString +
				". \nAfter withdrawing/depositing"; 
	}
}
