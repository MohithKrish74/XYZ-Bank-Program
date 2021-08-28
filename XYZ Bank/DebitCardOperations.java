package com.keyword;

public class DebitCardOperations
{
    public void balance(int cardNumber)
    {
        System.out.println("Balance USD "+Bank.debitBalanceList.get(cardNumber));
    }
    public void deposit(int cardNumber,double depositAmount)
    {
        Bank.debitBalanceList.put(cardNumber,Bank.debitBalanceList.get(cardNumber)+depositAmount);
        System.out.println("Deposited Successfully!!!");
    }
    public void withdraw(int cardNumber,double withdrawAmount)
    {
        Bank bank = new Bank();
        double charges = 0;
        if (withdrawAmount % bank.CASH_WITHDRAWAL_MULTIPLE != 0) {
            System.out.println("Please correct the amount of value. It should be multiple of USD "+bank.CASH_WITHDRAWAL_MULTIPLE);
        } else {
            charges = ((withdrawAmount<= bank.MINIMUM_BALANCE) ? (bank.CHARGES * withdrawAmount) : (2 * withdrawAmount * bank.CHARGES));
            Bank.debitBalanceList.put(cardNumber,Bank.debitBalanceList.get(cardNumber)-withdrawAmount-charges);
            if (Bank.debitBalanceList.get(cardNumber) > withdrawAmount && Bank.debitBalanceList.get(cardNumber) > bank.MINIMUM_BALANCE) {
                System.out.println("Charges USD " + charges);
                System.out.println("Withdrawn Successfully!!!");
            } else {
                System.out.println("Insufficient money in the account.Minimum balance in the bank should be USD 100. ");
            }
        }
    }
    public void swipe(int cardNumber,double swipes)
    {
        Bank bank = new Bank();
        if (swipes < Bank.debitBalanceList.get(cardNumber) && (Bank.debitBalanceList.get(cardNumber) - swipes) > bank.MINIMUM_BALANCE) {
            double cashBack;
            cashBack = (swipes * bank.CASHBACK);
            Bank.debitBalanceList.put(cardNumber, Bank.debitBalanceList.get(cardNumber)- swipes + cashBack);
            System.out.println("CashBack " + cashBack);
            System.out.println("Cashback added Successfully!!!");
        } else {
            System.out.println("Swipe operations cannot be performed!!!");
        }
    }
}