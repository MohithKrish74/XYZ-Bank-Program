package com.keyword;

import java.util.HashMap;
import java.util.Map;


public class Operations
{
    Bank bank = new Bank();
    public void balance() {
        System.out.println("Balance USD " + bank.balance);
    }
    public void deposit(double deposits) {
        bank.balance += deposits;
        System.out.println("Deposited Successfully!!!");
    }
    public void withdraw(double withdrawAmount) {
        double charges = 0;
        if (withdrawAmount % bank.CASH_WITHDRAWAL_MULTIPLE != 0) {
            System.out.println("Please correct the amount of value. It should be multiple of USD "+bank.CASH_WITHDRAWAL_MULTIPLE);
        } else {
            charges = ((withdrawAmount <= bank.MINIMUM_BALANCE) ? (bank.CHARGES * withdrawAmount) : (2 * withdrawAmount * bank.CHARGES));
            bank.balance = bank.balance - withdrawAmount - charges;
            if (bank.balance > withdrawAmount && bank.balance > bank.MINIMUM_BALANCE) {
                System.out.println("Charges USD " + charges);
                System.out.println("Withdrawn Successfully!!!");
            } else {
                System.out.println("Insufficient money in the account.Minimum balance in the bank should be USD 100. ");
            }
        }
    }
    public void swipe(double swipes)
    {
        if (swipes < bank.balance &&  (bank.balance - swipes) > bank.MINIMUM_BALANCE)
        {
            double cashBack;
            cashBack = (swipes * bank.CASHBACK) ;
            bank.balance = bank.balance - swipes + cashBack;
            System.out.println("CashBack " + cashBack);
            System.out.println("Cashback added Successfully!!!");
        }
        else
        {
            System.out.println("Swipe operations cannot be performed!!!");
        }
    }
}

class CreditAndDebit extends Operations {
    static int loginSuccessful = 1;
    static int credit = 1;
    double creditBalance;
    String nameOfCustomer;
    static Map<String, String> creditDetails = new HashMap<String, String>() ;
    static Map<String, String> creditNameFetch = new HashMap<String, String>();
    static Map<String, Double> creditBalanceList = new HashMap<String, Double>();
    static Map<String, String> debitDetails = new HashMap<String, String>() {{
        put("111", "1");
        put("222", "2");
    }};
    static Map<String, String> debitNameFetch = new HashMap<String, String>() {{
        put("111", "Ram");
        put("222", "Sam");
    }};
    static Map<String, Double> debitBalanceList = new HashMap<String, Double>() {{
        put("111", Bank.balanceList.get(("12345")));
        put("222", Bank.balanceList.get(("54321")));
    }};
    public boolean check(String cardNumber, String pinNumber) {
        if (creditDetails.containsKey(cardNumber) && creditDetails.get(cardNumber).equals(pinNumber)) {
            System.out.println("Hi " + creditNameFetch.get(cardNumber) + " welcome to XYZ Bank!!!");
            creditBalance = creditBalanceList.get(cardNumber);
            credit = 0;
            return true;
        }if (debitDetails.containsKey(cardNumber) && debitDetails.get(cardNumber).equals(pinNumber)) {
            System.out.println("Hi " + debitNameFetch.get(cardNumber) + " welcome to XYZ Bank!!!");
            //Bank.balance = debitBalanceList.get(cardNumber);//deb bal == bank bal
            Bank.balanceList.put(Bank.accountDebit.get(cardNumber),debitBalanceList.get(cardNumber));
            Bank.balance = debitBalanceList.get(cardNumber);//deb bal == bank bal
            nameOfCustomer = debitNameFetch.get(cardNumber);
            credit = 1;
            loginSuccessful = 1;
            return true;
        } else {
            System.out.println("No card number exists!!!");
            loginSuccessful = -1;
            return false;
        }
    }
    public void balance () {
        System.out.println("Balance USD " + creditBalance);
    }
    public void deposit ( double deposits){
        creditBalance += deposits;
        System.out.println("Deposited Successfully!!!");
    }
    public void withdraw ( double withdrawAmount){
        double charges;
        if (withdrawAmount % bank.CASH_WITHDRAWAL_MULTIPLE != 0) {
            System.out.println("Please correct the amount of value. It should be multiple of USD "+bank.CASH_WITHDRAWAL_MULTIPLE);
        } else {
            charges = ((withdrawAmount <= bank.MINIMUM_BALANCE) ? (bank.CHARGES * withdrawAmount) : (2 * withdrawAmount * bank.CHARGES));
            creditBalance = creditBalance - withdrawAmount - charges;
            if (creditBalance > withdrawAmount && creditBalance > bank.MINIMUM_BALANCE) {
                System.out.println("Charges USD " + charges);
                System.out.println("Withdrawn Successfully!!!");
            } else {
                System.out.println("Insufficient money in the credit card!!! ");
            }
        }
    }
    public void swipe (double swipes)
    {
        if (swipes < creditBalance && (creditBalance - swipes) > bank.MINIMUM_BALANCE) {
            double cashBack;
            cashBack = (swipes * bank.CASHBACK);
            creditBalance = creditBalance - swipes + cashBack;
            System.out.println("CashBack " + cashBack);
            System.out.println("Cashback added Successfully!!!");
        } else {
            System.out.println("Swipe operations cannot be performed!!!");
        }
    }
}
