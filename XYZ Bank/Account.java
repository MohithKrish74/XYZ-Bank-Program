package com.keyword;

public class Account
{
    private String name;
    private int age;
    private String gender;
    private double minBalance;
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
    public double getMinBalance() {return minBalance;}
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
    public void setMinBalance(double minBalance) { this.minBalance = minBalance;}

    public void showDetails()
    {
        System.out.println("Name : "+getName());
        System.out.println("Age : "+getAge());
        System.out.println("Gender : "+getGender());
        System.out.println("Minimum Balance : "+getMinBalance());

    }

}
