package com.techelevator;

public class BankAccount<balance, amountToWithdraw> {

    private String accountHolderName;
//    Returns the account holder name that the account belongs to.
    private String accountNumber;
//    Returns the account number that the account belongs to.
    private int balance = 0;
//    Returns the balance value of the bank account in dollars.

//    Constructor
    public BankAccount(String accountHolderName, String accountNumber) {
//        Returns the balance value of the bank account in dollars.
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        //    A new bank account requires an account holder name and account number. The balance is initialized to the dollar balance given.
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

//    Getters
    public String getAccountHolderName(){return accountHolderName;}
//    Returns the account holder name that the account belongs to.
//    Returns the account number that the account belongs to.
    public String getAccountNumber() {return accountNumber;}
//    Returns the balance value of the bank account in dollars.
    public int getBalance() {return balance;}


//    Method
//    Adds `amountToDeposit` to the current balance, and returns the new balance of the bank account.
    public int deposit(int amountToDeposit){
        this.balance += amountToDeposit;
        return this.balance;
    }

//    Subtracts `amountToWithdraw` from the current balance, and returns the new balance of the bank account.

    public int withdraw(int amountToWithdraw) {
        this.balance -= amountToWithdraw;
        return this.balance;
    }
    
}
