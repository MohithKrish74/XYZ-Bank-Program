package com.keyword;

public class AccountCreatingDetails
{
    static int id=2;
    private String name;
    private int age;
    private String gender;
    private String accountNumber;
    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getGender()
    {
        return gender;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public void customerRecord()
    {
        System.out.println();
        System.out.println("The Details are :");
        System.out.println("Name : "+getName());
        System.out.println("Age : "+getAge());
        System.out.println("Gender : "+getGender());

    }
}