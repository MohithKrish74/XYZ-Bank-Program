package com.keyword;

public class Account
{

    private User accountOwner;
    private int accountNumber;
    private double accountBalance;
    private int cifNumber;
    private DebitCard debitCard;
    private CreditCard creditCard;
    private String accountHolderName;
    public Account(User user, int accountNumber,double accountBalance,String accountHolderName){
        this.accountOwner=user;
        this.accountNumber=accountNumber;
        this.accountBalance=accountBalance;
        this.accountHolderName=accountHolderName;
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

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setCifNumber(int cifNumber) {
        this.cifNumber = cifNumber;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }

    public int getCifNumber()
    { return cifNumber; }

    public String getAccountHolderName() {
        return accountHolderName;
    }


}
