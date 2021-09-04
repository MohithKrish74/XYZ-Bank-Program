package com.keyword;

public class CreditCardOperations
{
    public void balance(CreditCard myCreditCard)
    {
        System.out.println("Balance USD "+myCreditCard.getCreditBalance());

    }
    public void deposit(CreditCard myCreditCard,double deposits)
    {
        double depositAfter = myCreditCard.getCreditBalance()+deposits;
        myCreditCard.setCreditBalance(depositAfter);
        System.out.println("Deposited Successfully!!!");
    }
    public void withdraw(CreditCard myCreditCard,double withdraw)
    {
        Bank bank = new Bank();
        double charges = 0;
        if (withdraw % bank.CASH_WITHDRAWAL_MULTIPLE != 0) {
            System.out.println("Please correct the amount of value. It should be multiple of USD "+bank.CASH_WITHDRAWAL_MULTIPLE);
        } else {
            charges = ((withdraw<= bank.MINIMUM_BALANCE) ? (bank.CHARGES * withdraw) : (2 * withdraw * bank.CHARGES));
            if (myCreditCard.getCreditBalance() > withdraw && myCreditCard.getCreditBalance() > bank.MINIMUM_BALANCE) {
                double withdrawAfter = myCreditCard.getCreditBalance() - withdraw - charges;
                myCreditCard.setCreditBalance(withdrawAfter);
                System.out.println("Charges USD " + charges);
                System.out.println("Withdrawn Successfully!!!");
            } else {
                System.out.println("Insufficient money in the account.Minimum balance in the bank should be USD 100. ");
            }
        }
    }
    public void swipe(CreditCard myCreditCard,double swipes)
    {
        Bank bank = new Bank();
        if (swipes < myCreditCard.getCreditBalance() && (myCreditCard.getCreditBalance() - swipes) > bank.MINIMUM_BALANCE) {
            double cashBack;
            cashBack = (swipes * bank.CASHBACK);
            double swipeAfter = myCreditCard.getCreditBalance()- swipes + cashBack;
            myCreditCard.setCreditBalance(swipeAfter);
            System.out.println("CashBack " + cashBack);
            System.out.println("Cashback added Successfully!!!");
        } else {
            System.out.println("Swipe operations cannot be performed!!!");
        }
    }
}