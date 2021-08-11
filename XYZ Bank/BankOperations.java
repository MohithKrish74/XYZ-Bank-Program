package com.keyword;

public class BankOperations
{
    static double availableBalance=250.0;
    public void balance()
    {
        System.out.println("Balance USD "+availableBalance);
    }
    public void deposit(double deposit)
    {
        availableBalance=availableBalance+deposit;
        System.out.println("Deposited Successfully!!!");
    }
    public void withdraw(double withdrawAmount)
    {
        double charges=0;
        if (withdrawAmount % 5 != 0)
        {
            System.out.println("Please correct the amount of value. It should be multiple of USD 5");
        }
        else
        {
            charges=((withdrawAmount<=100)?(2*withdrawAmount)/100:(4*withdrawAmount)/100);
            availableBalance = availableBalance - withdrawAmount - charges;//148
            if(availableBalance>withdrawAmount && availableBalance>100)
            {

                System.out.println("Charges USD " + charges);
                System.out.println("Withdrawn Successfully!!!");
            }
            else
            {
                System.out.println("Insufficient money in the account.Minimum balance in the bank should be USD 100. ");
                System.out.println("-------------------------------------------------------------------------------");
                System.exit(0);

            }
        }
    }
    public void swipe(double swipes)
    {
        if (swipes < availableBalance &&  (availableBalance - swipes) > 100)
        {
            double cashBack;
            cashBack = (swipes * 1) / 100;
            availableBalance= availableBalance - swipes + cashBack;
            System.out.println("CashBack " + cashBack);
            System.out.println("Cashback added Successfully!!!");
        }
        else
        {
            System.out.println("Swipe operations cannot be performed!!!");
            System.exit(1);
        }
    }


}
