package org.example;
import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        boolean counter = true;

        while(counter){
            System.out.println("=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");
            int userChoice = s.nextInt();

            switch (userChoice){
                case 1:
                    boolean accountNumberExisted = false;
                    System.out.print("\nEnter Account Number: ");
                    String accountNumber = s.next();
                    for(BankAccount bankAccount: bankAccounts){
                        if (bankAccount.getAccountNumber().equalsIgnoreCase(accountNumber)){
                            System.out.println("Account number existed on the system already.");
                            accountNumberExisted = true;
                        }


                    }
                    if (!accountNumberExisted) {
                        System.out.print("Enter Holder Name: ");
                        String bankAccountHolderName = s.next();
                        System.out.print("Initial Deposit (yes/no): ");
                        String hasInitialDeposit = s.next();

                        if (hasInitialDeposit.equalsIgnoreCase("yes")) {
                            System.out.print("Enter initial deposit amount: ");
                            double initialDeposit = s.nextDouble();
                            if(initialDeposit < 1){
                                System.out.println("Cannot deposit 0 or less than 0 amount.");
                            }else{
                                bankAccounts.add(new BankAccount(accountNumber, bankAccountHolderName, initialDeposit));
                                System.out.println("\nAccount created successfully!");
                            }
                        } else if (hasInitialDeposit.equalsIgnoreCase("no")) {
                            bankAccounts.add(new BankAccount(accountNumber, bankAccountHolderName));
                            System.out.println("\nAccount created successfully!");
                        }


                        break;
                    }
                    break;
                case 2:
                    for (BankAccount bankAccount : bankAccounts) {
                        bankAccount.display();
                    }
                    break;
                case 3:
                    System.out.print("\nWhat account number would you like to check the balance: ");
                    String accountNumberToCheck = s.next();
                    boolean hasFoundBankAccountNumber = false;
                    for(BankAccount bankAccount: bankAccounts){
                        if(bankAccount.getAccountNumber().equalsIgnoreCase(accountNumberToCheck)){
                            System.out.format("\nAvailable Balance of Account Number %s (%s): %.2f\n", accountNumberToCheck,bankAccount.getBankAccountHolderName(), bankAccount.getAvailableBalance());
                            hasFoundBankAccountNumber = true;
                        }
                    }

                    if (!hasFoundBankAccountNumber){
                        System.out.println("No Account Number matched on the system.");
                    }
                    break;
                case 4:
                    System.out.print("\nWhat account number would you like to deposit to: ");
                    String accountNumberToDeposit = s.next();
                    boolean hasFoundBankAccountNumberToDeposit = false;
                    for(BankAccount bankAccount: bankAccounts){
                        if(bankAccount.getAccountNumber().equalsIgnoreCase(accountNumberToDeposit)){
                            System.out.print("How much amount would you like to deposit: ");
                            double amountToDeposit = s.nextDouble();
                            bankAccount.deposit(amountToDeposit);
                            hasFoundBankAccountNumberToDeposit = true;
                        }
                    }
                    if (!hasFoundBankAccountNumberToDeposit){
                        System.out.println("No Account Number matched on the system.");
                    }
                    break;
                case 5:
                    System.out.print("\nWhat account number would you like to withdraw to: ");
                    String accountNumberToWithdraw = s.next();
                    boolean hasFoundBankAccountNumberToWithdraw = false;
                    for(BankAccount bankAccount: bankAccounts){
                        if(bankAccount.getAccountNumber().equalsIgnoreCase(accountNumberToWithdraw)){
                            System.out.print("How much amount would you like to withdraw? ");
                            double amountToWithdraw = s.nextDouble();
                            bankAccount.withdraw(amountToWithdraw);
                            hasFoundBankAccountNumberToWithdraw = true;
                        }
                    }
                    if (!hasFoundBankAccountNumberToWithdraw){
                        System.out.println("No Account Number matched on the system.");
                    }
                    break;
                case 6:
                    System.out.println("\nThank you for using GBanks!");
                    counter = false;
                    break;
                default:
                    System.out.println("\n Incorrect choice. Please try again.");


            }
            if(counter){
                System.out.print("\nWould you like to return to the menu? (yes/no): ");
                String doReturnMenu = s.next();
                if (doReturnMenu.equalsIgnoreCase("no")) {
                    System.out.println("Thank you for using GBanks!");
                    counter = false;
                }else if(doReturnMenu.equalsIgnoreCase("yes")){
                    System.out.println("Returning to menu");
                }else{
                    System.out.println("Invalid option. Will return back to menu.");
                }
            }

        }



    }



}