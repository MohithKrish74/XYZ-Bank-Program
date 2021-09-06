package com.keyword;

import java.util.ArrayList;
import java.util.HashMap;


public class Bank {
    public double CHARGES = 0.02, CASHBACK = 0.01;
    public int CASH_WITHDRAWAL_MULTIPLE = 5, MINIMUM_BALANCE = 100;
    private static ArrayList<Account> bankAccounts = new ArrayList<>();
    private static ArrayList<DebitCard> debitCredentials = new ArrayList<>();
    private static HashMap<Integer, Integer> debitAccount = new HashMap<>();
    private static HashMap<Integer, Integer> creditAccount = new HashMap<>();
    private static ArrayList<CreditCard> creditCredentials = new ArrayList<>();
    static {
        DebitCard debitCard = new DebitCard();
        CreditCard creditCard = new CreditCard();
        Bank bank = new Bank();
        User user1 = new User("Ram", 24, "M");
        Account account1 = new Account(user1, 12345, 100.);
        debitCard.setCardNo(111);
        debitCard.setPinNo(1);
        debitCard.setDebitBalance(100.);
        account1.setDebitCard(debitCard);
        bank.addDebitCredentials(debitCard);
        bank.addDebitAccount(111, 1);
        creditCard.setCardNo(100);
        creditCard.setPinNo(1);
        creditCard.setCreditBalance(1000.);
        account1.setCreditCard(creditCard);
        bank.addCreditCredentials(creditCard);
        bank.addCreditAccount(100, 1);
        bank.addAccount(account1);


    }

    public HashMap<Integer, Integer> getDebitAccount() {
        return debitAccount;
    }

    public void addDebitAccount(int cardNumber, int pinNumber) {
        this.debitAccount.put(cardNumber, pinNumber);
    }

    public HashMap<Integer, Integer> getCreditAccount() {
        return creditAccount;
    }

    public void addCreditAccount(int cardNumber, int pinNumber) {
        this.creditAccount.put(cardNumber, pinNumber);
    }

    public ArrayList<DebitCard> getDebitCredentials() {
        return this.debitCredentials;
    }

    public void addDebitCredentials(DebitCard debitCard) {
        this.debitCredentials.add(debitCard);
    }

    public ArrayList<CreditCard> getCreditCredentials() {
        return this.creditCredentials;
    }

    public void addCreditCredentials(CreditCard creditCard) {
        this.creditCredentials.add(creditCard);
    }


    public ArrayList<Account> getAccount() {
        return this.bankAccounts;
    }

    public void addAccount(Account newAccount) {
        this.bankAccounts.add(newAccount);
    }

    public boolean checkAccount(int accountNumber) {
        for (Account acc : bankAccounts) {
            if (acc.getAccountNumber() == (accountNumber)) {
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
        return new Account(new User("NULL", 0, "NULL"), 0, 0);
    }

    public boolean checkCreditOrDebitAccount(int cardNumber, int pinNumber) {
        for (DebitCard acc : debitCredentials) {
            if (acc.getCardNo() == (cardNumber) && debitAccount.get(cardNumber).equals(pinNumber)) {
                return true;
            }
            for (CreditCard account : creditCredentials) {
                if (account.getCardNo() == (cardNumber) && creditAccount.get(cardNumber).equals(pinNumber)) {
                    return true;
                }


            }
        }
        return false;
    }

    public DebitCard getDebitAccount (int cardNumber){
            for (DebitCard acc : debitCredentials) {
                if (acc.getCardNo() == (cardNumber)) {
                    return acc;
                }

            }
            return new DebitCard();
    }

    public CreditCard getCreditAccount (int cardNumber){
            for (CreditCard acc : creditCredentials) {
                if (acc.getCardNo() == (cardNumber)) {
                    return acc;
                }

            }
            return new CreditCard();
        }
    }









