package com.keyword;

import java.util.HashMap;
import java.util.Map;
public class BankCustomerInfo
{
    private int id;
    private String accountNumberOfCustomer;
    static Map<Integer,String> userId = new HashMap<Integer,String>(){{
        put(1,"12345");
        put(2,"54321");
    }};
    static Map<String,String> userName = new HashMap<String,String>(){{
        put("12345","Ram");
        put("54321","Sam");
    }};

    public int getId()
    {
        return id;
    }
    public String getAccountNumberOfCustomer()
    {
        return accountNumberOfCustomer;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void setAccountNumberOfCustomer(String accountNumberOfCustomer)
    {
        this.accountNumberOfCustomer = accountNumberOfCustomer;
    }

}
