package com.keyword;

public class Account
{

    private User accountOwner;
    private int accountNumber;
    private double accountBalance;
    private int cifNumber;
    private DebitCard debitCard;
    private CreditCard creditCard;

    public Account(User user, int accountNumber,double accountBalance){
        this.accountOwner=user;
        this.accountNumber=accountNumber;
        this.accountBalance=accountBalance;

    }

    public User getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(User accountOwner) {
        this.accountOwner = accountOwner;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    public void setDebitCard(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

     void setCifNumber(int cifNumber) {
        this.cifNumber = cifNumber;
    }


    public int getAccountNumber() {
        return accountNumber;
    }

     double getAccountBalance() {
        return this.accountBalance;
    }

    public int getCifNumber()
    { return cifNumber; }



}
