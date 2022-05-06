package com.techelevator;

public class BankAccount implements Accountable {

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int deposit(int amountToDeposit) {
        balance = balance + amountToDeposit;
        return balance;
    }

    public int withdraw(int amountToWithdraw) {
        balance = balance - amountToWithdraw;
        return balance;
    }


//    Add a new `transferTo()` method to transfer money between `BankAccount`s
//    Add method to allow `BankAccount`s to transfer money to SavingsAccount` and `CheckingAccount`

//    Step #1
    public int transferTo(BankAccount destinationAccount, int transferAmount) {

        withdraw(transferAmount);
//        The parameter "transferAmount" does not need to be called again with .this
        destinationAccount.deposit(transferAmount);
//        The parameter "destinationAccount" is being used to .deposit the "transferAmount" from the withdraw
        return getBalance();
//        Returning the balance


//        Step #3  Make the `BankAccount` class accountable

//        Add the `Accountable` interface to `BankAccount`, making `BankAccount` and all the classes that
//        inherit from `BankAccount` accountable classes.




    }
}


//        System.out.println();


//      Withdraws "transferAmount" from this account
//        Deposits "destinationAccount"
//        Return getBalance

// `transferTo(BankAccount destinationAccount, int transferAmount)`
//    `int`
//    Withdraws `transferAmount` from this account, deposits it into `destinationAccount`,
//    and returns the new balance of this account.
