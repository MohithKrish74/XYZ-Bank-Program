package com.keyword;

public class CreditCardOperations extends Operations
{

    public void balance(int cardNumber)
    {
       System.out.println("Balance USD "+Bank.balanceList.get(cardNumber));
    }
    public void deposit(int cardNumber,double depositAmount)
    {
        double depositAfter = Bank.balanceList.get(cardNumber)+depositAmount;
        Bank.balanceList.put(cardNumber,depositAfter);
        System.out.println("Deposited Successfully!!!");
    }
    public void withdraw(int cardNumber,double withdrawAmount)
    {
        Bank bank = new Bank();
        CreditCard creditCard = new CreditCard();
        double charges = 0;
        if (withdrawAmount % bank.CASH_WITHDRAWAL_MULTIPLE != 0) {
            System.out.println("Please correct the amount of value. It should be multiple of USD "+bank.CASH_WITHDRAWAL_MULTIPLE);
        } else {
            charges = ((withdrawAmount<= bank.MINIMUM_BALANCE) ? (bank.CHARGES * withdrawAmount) : (2 * withdrawAmount * bank.CHARGES));
            double withdrawAfter = Bank.balanceList.get(cardNumber)-withdrawAmount-charges;
            Bank.balanceList.put(cardNumber,withdrawAfter);
            if (Bank.balanceList.get(cardNumber) > withdrawAmount && Bank.balanceList.get(cardNumber) > bank.MINIMUM_BALANCE) {
                System.out.println("Charges USD " + charges);
                System.out.println("Withdrawn Successfully!!!");
            } else {
                System.out.println("Insufficient money in the account.Your Credit score will be affected. ");
                creditCard.setCreditScore(creditCard.getCreditScore()-10);

            }
        }
    }
    public void swipe(int cardNumber,double swipes)
    {
        Bank bank = new Bank();
        if (swipes < Bank.balanceList.get(cardNumber) && (Bank.balanceList.get(cardNumber) - swipes) > bank.MINIMUM_BALANCE) {
            double cashBack;
            cashBack = (swipes * bank.CASHBACK);
            double swipeAfter = Bank.balanceList.get(cardNumber)- swipes + cashBack;
            Bank.balanceList.put(cardNumber, swipeAfter);
            System.out.println("CashBack " + cashBack);
            System.out.println("Cashback added Successfully!!!");
        } else {
            System.out.println("Swipe operations cannot be performed!!!");
        }
    }
}
