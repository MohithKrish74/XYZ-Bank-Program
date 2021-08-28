package com.keyword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank
{
    public double CHARGES=0.02,CASHBACK=0.01;
    public int CASH_WITHDRAWAL_MULTIPLE=5,MINIMUM_BALANCE=100;
    private static ArrayList<Account> bankAccounts = new ArrayList<>();

    private static HashMap<Integer,Integer> debitCredentials = new HashMap<>();
    private static HashMap<Integer,Integer> creditCredentials = new HashMap<>();
    static Map<Integer,Double> creditBalanceList = new HashMap<>(){{
       /* creditBalanceList.put(100, 600.);
        creditBalanceList.put(200, 100.);*/
    }};
    static Map<Integer,Double> debitBalanceList = new HashMap<>();{{
        debitBalanceList.put(111,600.);
        debitBalanceList.put(222,500.);
    }};



    public static HashMap<Integer, Integer> getDebitCredentials() {
        return debitCredentials;
    }
    public void addDebitAccount(int cardNumber,int pinNumber) {
        this.debitCredentials.put(cardNumber,pinNumber);
    }

    public static HashMap<Integer, Integer> getCreditCredentials() {
        return creditCredentials;
    }
    public void addCreditAccount(int cardNumber,int pinNumber) {
        this.creditCredentials.put(cardNumber,pinNumber);
    }

    public ArrayList<Account> getAccount() {
        return this.bankAccounts;
    }
    public void addAccount(Account newAccount) {
        this.bankAccounts.add(newAccount);
    }

    public Boolean checkAccount(int accountNumber) {
        for(Account acc : bankAccounts) {
            if(acc.getAccountNumber()==(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    public Account getAccount(int accountNumber) {
        for (Account acc : bankAccounts) {
            if (acc.getAccountNumber() == (accountNumber)) {
                return acc;
            }
        }
        return new Account(new User("NULL",0,"NULL"),0,0,"NULL");
    }
    public boolean checkDebitOrCreditAccount(int cardNumber,int pinNumber)
    {
        if(debitCredentials.containsKey(cardNumber))
        {
            if(debitCredentials.get(cardNumber)==pinNumber)
            {
                System.out.println("Login successful!!!");
                BankService.debit(cardNumber);
                return true;
            }
            else
            {
                System.out.println("Invalid Password!!!");
            }
        }
        else if(creditCredentials.containsKey(cardNumber))
        {
            if(creditCredentials.get(cardNumber)==pinNumber)
            {
                System.out.println("Login successful!!!");
                BankService.credit(cardNumber,Bank.creditBalanceList.get(cardNumber));
                return true;
            }
            else
            {
                System.out.println("Invalid Password!!!");
            }
        }
        else
        {
            System.out.println("Card number does not exists!!!");
            return false;
        }
        return false;
    }

}





