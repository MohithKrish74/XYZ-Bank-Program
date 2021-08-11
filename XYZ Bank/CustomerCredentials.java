package com.keyword;

public class CustomerCredentials
{
    private int id;
    private String name;
    private String accountNumber;
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getAccountNumber()
    {
        return accountNumber;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }
}