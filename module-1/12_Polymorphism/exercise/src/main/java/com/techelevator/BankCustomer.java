package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer implements Accountable {

//    #### Step Five: Implement the `BankCustomer` class

//    Implement the `BankCustomer` class. A bank customer has a list of `Accountable`s.

//    Attributes = Getters & Setters

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable>accounts = new ArrayList<>();



//    Getters
    public String getName() {return name;}
//    The account holder name that the account belongs to
    public String getAddress() {return address;}
//    The address of the customer.
    public String getPhoneNumber() {return phoneNumber;}
//    The phone number of the customer.
    public Accountable[]getAccounts() {
        return accounts.toArray(new Accountable[accounts.size()]);
    }
//The customer's list of Accountables

//    Setters
        public void setName (String name){
            this.name = name;
        }
        public void setAddress (String address){
            this.address = address;
        }
        public void setPhoneNumber (String phoneNumber){
            this.phoneNumber = phoneNumber;
        }

        public void addAccount (Accountable newAccount){

            accounts.add(newAccount);
        }

        @Override
                public int getBalance() {
                return 0;
        }


        public boolean isVip(){
            int sum = 0;
            for(Accountable account : accounts){
                sum += account.getBalance();
            }

//            for(int i = 0; i < accounts.size(); i++){
//                Accountable account = accounts.get(i);
//                sum = sum + account.getBalance();
//            }

            if(sum >= 25000){
                return true;
            } else {
                return false;
            }
        }

    }


//    Method isVip

//       for each loop through a list

//  for each loop syntax

//    for (String combined : accounts) {

//  For loop for iterating over the list

//    for (int i = 0; i < myList.size(); i++) {
//
//        if(accounts.sum() >= 25,000) {
//            return true;
//            System.out.println("VIP Customer")
//        else if (accounts.sum() < 25,000)
//        return false;
//        System.out.println("Not a VIP Customer")
//        }


//combined account balances
// At least > 25,000 considered VIP customers
// Returns true if the sum of all accounts is >= 25,00 else is false

//    Customers whose combined account balances (credits minus debts)
//  Add a method called `isVip` to the `BankCustomer` class that returns true if the sum of all
//  accounts belonging to the customer is at least $25,000 and false otherwise.




