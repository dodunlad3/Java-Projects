package Bank;


public class BankAccount{
	protected String userKey;
	protected double balance;
	protected double lastTransaction;
	
	public BankAccount(String userKey, double initialBalance){
		this.userKey = userKey;
		balance = initialBalance;
		lastTransaction = 0;
	}
	
	/*
	 * Gets the current balance in the account
	 * 
	 * @return the current balance of the account
	 */
	public double checkBalance() {
		return balance;
	}
	
	/*
	 * Allows users to change their user Key
	 * 
	 * @param newKey
	 * 				the new user key
	 */
	public void setUserKey(String newKey) {
		userKey = newKey;
	}
	
	/*
	 * Gets the account's userKey
	 * 
	 * @return the user key
	 */
	public String getUserKey() {
		return userKey;
	}
	
	/*
	 * Deposits money into the account and updates the last transaction
	 * 
	 * 
	 * @param amount
	 * 				the amount being deposited
	 */
	public void deposit(double amount) throws Exception{
		if(amount <= 0) {
			throw new Exception();
		}
		balance += amount;
		lastTransaction = amount;
	}
	
	/*
	 * Withdraws money from the account and updates the last transaction
	 * 
	 * @param amount
	 * 				the amount being withdrawn
	 */
	public void withdraw(double amount) throws Exception{
		if(amount <= 0) {
			throw new Exception("Invalid ");
		}
		if(amount > balance) {
			throw new Exception("Error! Insufficient Funds.");
		}
		balance -= amount;
		lastTransaction = -(amount);
	}
	
	/*
	 * Displays what the last transaction was.
	 * 
	 * @return the last transaction
	 */
	public String getLastTransaction() {
		if(lastTransaction == 0) {
			return "No Transaction Recorded";
		}
		else if(lastTransaction > 0) {
			return "Deposit of $" + Math.abs(lastTransaction);
		}
		else {
			return "Withdrawl of $" + Math.abs(lastTransaction);
		}
			
		
	}
	
	
}