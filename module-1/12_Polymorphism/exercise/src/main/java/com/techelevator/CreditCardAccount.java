package com.techelevator;

public class CreditCardAccount implements Accountable {

//    Step Four: Implement a new CreditCardAccount class
//    "can-do" `Accountable`. meaning it's implementing the interface

//    Constructor

//`CreditCardAccount(String accountHolder, String accountNumber)`

    private String accountHolder;
    private String accountNumber;
    private int debt = 0;


    public CreditCardAccount(String accountHolder, String accountNumber) {

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;

    }

//    A new credit card account requires an account holder name and account number.
//    The debt defaults to a 0 dollar balance.


//    Attributes = Getters

//    Getters

    public String getAccountHolder() {
        return accountHolder;
    }

    //    The account holder name that the account belongs to.
    public String getAccountNumber() {
        return accountNumber;
    }

    //    The account number that the account belongs to.
    public int getDebt() {
        return debt;
    }

    //    The amount the customer owes.
    public int getBalance() {
        return -debt;
    }


//    Method

    //    Removes `amountToPay` from the amount owed and returns the new total amount owed.
    public int pay(int amountToPay) {
        debt -= amountToPay;
        return debt;
    }

    //    Adds `amountToCharge` to the amount owed, and returns the new total amount owed.
    public int charge(int amountToCharge) {
        debt += amountToCharge;
        return debt;
    }

}





//    The balance for the accounting must be the debt as a negative number. Negative number since we are dealing with credit.


