package com.keyword;

import java.util.HashMap;
import java.util.Map;
enum Options
{
    VISIT_A_BANK,
    VISIT_A_SHOP,
    EXIT
}
public class Bank
{
    public double CHARGES=0.02,CASHBACK=0.01;
    public int CASH_WITHDRAWAL_MULTIPLE=5,MINIMUM_BALANCE=100;
    static double balance;
    static int loginSuccessful = 1;
    static Map<String,String> account = new HashMap<String,String>(){{
        put("12345","Ram");
        put("54321","Sam");
    }};
    static Map<String,Double> balanceList = new HashMap<String,Double>(){{
        put("12345",150.00);
        put("54321",100.00);
    }};
    static Map<String,String > accountDebit = new HashMap<String,String>(){{
        put("111", "12345");
        put("222", "54321");
    }};
    public boolean checkAccount(String accountNumber)
    {
        if(account.containsKey(accountNumber))
        {
            System.out.println("Hi "+account.get(accountNumber)+" welcome to XYZ Bank!!!");
            balance=balanceList.get(accountNumber);
            loginSuccessful = 1;
            return true;
        }
        else
        {
            System.out.println("Invalid account number!!!.");
            loginSuccessful = -1;
            return false;
        }
    }
}

