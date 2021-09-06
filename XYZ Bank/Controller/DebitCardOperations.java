package com.keyword;

public class DebitCardOperations extends Operations
{
    public void balance(DebitCard myDebitAccount)
    {
        System.out.println("Balance USD "+myDebitAccount.getDebitBalance());
    }

    public void deposit(DebitCard myDebitAccount,double deposits)
    {
        double depositAfter = myDebitAccount.getDebitBalance()+deposits;
        myDebitAccount.setDebitBalance(depositAfter);
        System.out.println("Deposited Successfully!!!");
    }

    public void swipe(DebitCard myDebitAccount,double swipes)
    {
        Bank bank = new Bank();
        if (swipes < myDebitAccount.getDebitBalance() && (myDebitAccount.getDebitBalance() - swipes) > bank.MINIMUM_BALANCE) {
            double cashBack;
            cashBack = (swipes * bank.CASHBACK);
            double swipeAfter = myDebitAccount.getDebitBalance()- swipes + cashBack;
            myDebitAccount.setDebitBalance(swipeAfter);
            System.out.println("CashBack " + cashBack);
            System.out.println("Cashback added Successfully!!!");
        } else {
            System.out.println("Swipe operations cannot be performed!!!");
        }
    }
}