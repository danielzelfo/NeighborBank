package BankingApplication.BankingSystem;
import java.text.NumberFormat;

/*Folder/Project Name	: Project8
 * Programmer Name		: Daniel Zelfo
 * Date					: 
 * Class Name			: Account
 * Project Description	: 
  */
public abstract class Account
{
	
	/*
	 * instance variables:
	 * 
	 * 	firstName - user's first name
	 * 	lastName - user's last name
	 * 	accountType - checking account or savings account
	 * 	pin - unique pin associated with account
	 * 	balance - current balance of account
	 * 	
	 */
	private String firstName,
				   lastName,
				   accountType;
	private short pin;
	private float balance;
	
	//instance variables of formats
	/*
	 * these will be used by the subclasses CheckingAccount and SavingsAccount but are not different for either
	 */
	private String transactionFormat = "%-6s%-17s%-15s%-12s%-10s%-10s%-10s%n";
	private String accountFormat = "%-20s%-10s%-15s%-10s%n";
	private NumberFormat dollarFormat = NumberFormat.getCurrencyInstance();
	
	
	//Account constructor with all fields
	protected Account(String firstName, String lastName, String accountType, short pin, float balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountType = accountType;
		this.pin = pin;
		this.balance = balance;
	}

	//the withdraw method - this method subtracts the given amount from the balance and returns the transaction log
	public abstract String withdraw(float amount);
	//a fee getter
	public abstract float getFee();
	//the deposit method - this method adds the given amount from the balance and returns the transaction log
	public abstract String deposit(float amount);
	//returns transaction when cancelled
	public abstract String getCancelledTransactionLog();
	
	
	/*
	 * 
	 * BUSINESS VALIDATION METHODS BELOW
	 * 
	 */
	
	//used to validate if a pin is used
	public abstract boolean validateUsedPin(short pin);
	//used to check if a charge must be applied
	public abstract boolean validateChargeFee(float amount);
	//used to validate that the account has enough funds for the withdrawal
	public abstract boolean validateSufficientFunds(float amount);

	//getters - to give access to the subclasses
	protected String getFirstName() {
		return this.firstName;
	}
	protected String getLastName() {
		return this.lastName;
	}
	protected String getAccountType() {
		return this.accountType;
	}
	protected short getPin() {
		return this.pin;
	}
	protected float getBalance() {
		return this.balance;
	}
	protected String getTransactionFormat() {
		return this.transactionFormat;
	}
	protected String getAccountFormat() {
		return this.accountFormat;
	}
	protected NumberFormat getDollarFormat() {
		return this.dollarFormat;
	}
	
	//setters
	protected void setBalance(float balance) {
		this.balance = balance;
	}

	

	
	
}
