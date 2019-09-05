package BankingApplication.BankingSystem;
/*Folder/Project Name	: Project8
 * Programmer Name		: 
 * Date					:
 * Class Name			: SavingsAccount
 * Project Description	: 
  */
public class SavingsAccount extends Account 
{
	//Instance variables: fee - fee of $2.50 is applied for withdrawals over $2000
	private float fee = 2.50f;
	private float feeThreshold = 2000.00f;
	
	//must make startingBalance static to use in constructor
	private static float startingBalance = 500.00f;
	
	//SavingsAccount constructor using superclass
	public SavingsAccount(String firstName, String lastName, short pin) {
		//assuming the new account will start with $500
		super(firstName, lastName, "Savings", pin, startingBalance);
	}
	
	//The withdraw method with a fee of $2.00
	public String  withdraw(float amount) {
		boolean chargeFee = this.validateChargeFee(amount);
		this.setBalance(this.getBalance()-(amount + (chargeFee ? this.fee : 0) ));
		return String.format(this.getTransactionFormat(),
				this.getPin(), this.getLastName() + ", " + this.getFirstName(), this.getAccountType(), "Withdraw", this.getDollarFormat().format(amount), !chargeFee ? "\t" : this.getDollarFormat().format(this.fee), this.getDollarFormat().format(this.getBalance()) );
	}
	
	//fee getter
	public float getFee() {
		return this.fee;
	}
	
	//the deposit method - this method adds the given amount from the balance and returns the transaction log
	public String deposit(float amount) {
		this.setBalance(this.getBalance() + amount);
		return String.format(this.getTransactionFormat(),
				this.getPin(), this.getLastName() + ", " + this.getFirstName(), this.getAccountType(), "Deposit", this.getDollarFormat().format(amount),"\t", this.getDollarFormat().format(this.getBalance()) );
	}
	
	//the toString method - returns a custom formatted string of the account information
	public String toString() {
		return String.format(this.getAccountFormat(),
				this.getFirstName() + " " + this.getLastName(), this.getPin(), this.getAccountType(), this.getDollarFormat().format(this.getBalance()));
	}
	
	public String getCancelledTransactionLog() {
		return String.format(this.getTransactionFormat(),
				this.getPin(), this.getLastName() + ", " + this.getFirstName(), this.getAccountType(), "Withdraw", "Canceled", "", "" );
	}
	
	/*
	 * BUSINESS VALIDATION METHODS START:
	 */
	
	//check if pin is already used
	public boolean validateUsedPin(short pin) {
		if (pin == this.getPin())
			return true;
		return false;
	}
	
	//check if a fee must be charged
	public boolean validateChargeFee(float amount) {
		if (amount > this.feeThreshold)
			return true;
		return false;
	}
	
	//check if account has sufficient funds for a withdrawal
	public boolean validateSufficientFunds(float amount) {
		if((amount + ( validateChargeFee(amount) ? this.getFee() : 0 ) ) <= this.getBalance())
			return true;
		return false;
	}
}
