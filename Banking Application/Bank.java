package Bank;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
/**
 * 
 */
/**
 * @author Daniel Odunlade
 *
 */

public class Bank{
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        ArrayList<BankAccount> Accounts = new ArrayList<>();
        int choice;
        do {
            System.out.println("Welceome to D Bank");
            System.out.println("---------Menu---------" + "\n1. Create an account \n2. Login \n3. Quit");
            choice = input.nextInt();
            input.nextLine();
            switch(choice) {
                case 1:
                    System.out.println("Please enter a userKey:");
                    String key = input.nextLine();
                    System.out.println("Please enter the initial deposit amount:");
                    double amount = input.nextDouble();
                    input.nextLine();
                    Accounts.add(new BankAccount(key, amount));
                    break;
                case 2:
                    System.out.println("Please enter the userKey:");
                    String logKey = input.nextLine();
                    BankAccount acc = null;
                    for(BankAccount account: Accounts) {
                        if(logKey.equals(account.getUserKey())) {
                            acc = account;
                            break;
                        }
                    }
                    if(acc == null) {
                        System.out.println("userKey invalid. Account not found.");
                        break;
                    }
                    int choiceTwo;
                    do {
                        System.out.println("1. Check Balance \n2. Deposit \n3. Withdraw \n4. Last Transaction \n5. Quit");
                        choiceTwo = input.nextInt();
                        input.nextLine();
                        switch(choiceTwo) {
                            case 1:
                                System.out.println("Your current balance is "+ acc.checkBalance());
                                break;
                            
                            case 2:
                                System.out.println("Enter the deposit amount:");
                                double amountTwo = input.nextDouble();
                                input.nextLine();
							try {
								acc.deposit(amountTwo);
							} catch (Exception e) {
								
								e.printStackTrace();
							}
							TimeUnit.SECONDS.sleep(1);
							System.out.println("Your new balance is "+ acc.checkBalance());
                                break;
                            
                            case 3:
                                System.out.println("Enter the withdrawl amount:");
                                double withdrawAmount = input.nextDouble();
                                input.nextLine();
							try {
								acc.withdraw(withdrawAmount);
							} catch (Exception e) {
								e.printStackTrace();
							}
							TimeUnit.SECONDS.sleep(1);
                            System.out.println("Your new balance is "+ acc.checkBalance());
                            break;
                            
                            case 4:
                            	System.out.println(acc.getLastTransaction());
                            	break;
                           
                            case 5:
                            	break;
                            
                            default:
                            System.out.println("Invalid choice, please try again");
                            break;
                        }
                    } 
                    while(choiceTwo != 5);
                    	break;
                        case 3:
                            break;
                        	default:
                            System.out.println("Invalid choice, please try again");
                            break;
            }
        } 
        while (choice != 3);
        }
    }