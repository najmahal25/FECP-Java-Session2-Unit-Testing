package org.example;

public class BankAccount {
    private String accountNumber;
    private String bankAccountHolderName;
    private double availableBalance;

    public BankAccount(String accountNumber, String bankAccountHolderName, double initialDeposit){
        this.accountNumber = accountNumber;
        this.bankAccountHolderName = bankAccountHolderName;
        this.availableBalance = (float)initialDeposit;
    }

    public BankAccount(String accountNumber, String bankAccountHolderName){
        this.accountNumber = accountNumber;
        this.bankAccountHolderName = bankAccountHolderName;
    }

    void deposit(double amount){
        if(amount < 1){
            System.out.println("Cannot deposit 0 or less than 0 amount");
        }else{
            availableBalance += amount;
            System.out.println("Deposit successful!");
        }
    }

    void withdraw(double amount){
        if(amount < 1){
            System.out.println("Cannot withdraw 0 or less than 0 amount");
        }

        else if(amount > this.availableBalance){
            System.out.println("Amount is greater than the available balance.");
        }else {
            availableBalance -= amount;
            System.out.println("Withdraw successful!");
        }
    }

    void display(){
        System.out.printf("\nAccount Number: %s\nBank Account Holder Name: %s\nAvailable Balance: %.2f\n", this.accountNumber, this.bankAccountHolderName, this.availableBalance);
    }

    public String getBankAccountHolderName() {
        return bankAccountHolderName;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
