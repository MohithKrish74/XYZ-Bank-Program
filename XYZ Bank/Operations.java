package com.keyword;

public class Operations
{
    public void balance(Account myAccount)
    {
        System.out.println("Balance USD "+myAccount.getAccountBalance());

    }
    public void deposit(Account myAccount,double deposits)
    {
        double depositAfter = myAccount.getAccountBalance()+deposits;
        myAccount.setAccountBalance(depositAfter);
        System.out.println("Deposited Successfully!!!");
    }
    public void withdraw(Account myAccount,double withdraw)
    {
        Bank bank = new Bank();
        double charges = 0;
        if (withdraw % bank.CASH_WITHDRAWAL_MULTIPLE != 0) {
            System.out.println("Please correct the amount of value. It should be multiple of USD "+bank.CASH_WITHDRAWAL_MULTIPLE);
        } else {
            charges = ((withdraw<= bank.MINIMUM_BALANCE) ? (bank.CHARGES * withdraw) : (2 * withdraw * bank.CHARGES));
            double withdrawAfter = myAccount.getAccountBalance() - withdraw - charges;
            myAccount.setAccountBalance(withdrawAfter);
            if (myAccount.getAccountBalance() > withdraw && myAccount.getAccountBalance() > bank.MINIMUM_BALANCE) {
                System.out.println("Charges USD " + charges);
                System.out.println("Withdrawn Successfully!!!");
            } else {
                System.out.println("Insufficient money in the account.Minimum balance in the bank should be USD 100. ");
            }
        }
    }
}
