package com.techelevator;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }


//Method

    @Override
    public int withdraw(int amountToWithdraw) {

        if (super.getBalance() - amountToWithdraw < 0 && super.getBalance() - amountToWithdraw > -100) {
            super.withdraw(10);

        }
        if (-100 >= (super.getBalance() - amountToWithdraw)) {
            return  getBalance();

        }

        return super.withdraw(amountToWithdraw);
    }

}


//Another way to go about it :)
//    if (getBalance() - amountToWithdraw > -100) {
//        super.withdraw(amountToWihdraw);
//
//        if (super.getBalance() < 0) {
//            super.withdraw(10);
//        }
//        return getBalance();
//            }


//     A request to overdraw a checking account by $100.00 or more (before overdraft fee) fails and the balance remains the same.<br><br>

//     For example, if the current balance is -$89.00, and the amount to withdraw is $10.00, the resulting balance is -$99.00.

//     The withdrawal is permitted since the new balance is greater than -$100.00. The $10.00 overdraft fee is then charged against the account,
//     resulting in a final balance of -$109.00.<br><br>A withdrawal of $11.00 in the same situation fails because the new balance
//     would be -$100.00 which is equal to,
//     *not greater than*, the lower limit of -$100.00.


//Balance < $0.00
//Balance Max/Limit > -$100.00
//Then there is $10 overdraft fee
//Lowest limit of -$100.00
//Request is allowed if the new balance is > than -$100.00
