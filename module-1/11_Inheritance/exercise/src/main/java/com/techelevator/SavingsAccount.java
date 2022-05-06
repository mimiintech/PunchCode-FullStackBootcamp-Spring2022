package com.techelevator;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }



//    Method

    @Override
    public int withdraw(int amountToWithdraw) {

        if (getBalance() - amountToWithdraw < 150 && getBalance() - amountToWithdraw > 0 ) {
            super.withdraw(2);
        }
        if (getBalance() - amountToWithdraw < 0)
            return getBalance();
        return super.withdraw(amountToWithdraw);
    }
}


//    withdraw
//If the remaining balance is less than $150.00 after a withdrawal is made, an additional $2.00 service charge is withdrawn from the account.
//If a withdrawal is requested that would result in a negative balance (including the service charge), the withdrawal fails and balance remains the same. No fees are incurred.

//    Remaining balance is < 150 after a withdrawal
//     Add 2 withdrawn from account
//    If withdrawal results in a negative balance including the service, then the withdrawal fails, and the balance remains the same.
