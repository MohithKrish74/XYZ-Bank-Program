package com.keyword;

import java.util.Scanner;

public class BankService
{
        public static void generatingAccountNumber()
        {
            Scanner in = new Scanner(System.in);
            int accountNumber = 0;
            String accountNumberString = Integer.toString(accountNumber);
            AccountCreatingDetails creatingDetails = new AccountCreatingDetails();
            CustomerCredentials credentials = new CustomerCredentials();
            BankCustomerInfo accountNumberChecking = new BankCustomerInfo();
            WorkingOn working = new WorkingOn();
            System.out.print("Enter your name : ");
            String customerName = in.next();
            System.out.print("Enter your Age : ");
            int customerAge = in.nextInt();
            System.out.print("Enter your Gender : ");
            String customerGender = in.next();
            creatingDetails.setName(customerName);
            creatingDetails.setAge(customerAge);
            creatingDetails.setGender(customerGender);
            creatingDetails.customerRecord();
            while (!(BankCustomerInfo.userName.containsKey(accountNumberString)) && !(accountNumberString.isBlank()) && !(accountNumberString.length()==5)) {
                int min = 10000;
                int max = 99999;
                accountNumber = (int) (Math.random() * (max - min + 1) + min);
                accountNumberString = Integer.toString(accountNumber);
                break;
            }
            AccountCreatingDetails.id++;
            System.out.println("Id :" + AccountCreatingDetails.id);
            System.out.println("Account Number :" + accountNumberString);
            System.out.println("Your Account is created Successfully!!! ");
            credentials.setName(customerName);
            credentials.setAccountNumber(accountNumberString);
            BankCustomerInfo.userId.put(AccountCreatingDetails.id, credentials.getAccountNumber());
            BankCustomerInfo.userName.put(credentials.getAccountNumber(), credentials.getName());
            System.out.println();
            working.processing(1);

        }

        public static void main(String[] args)
        {
            Scanner in = new Scanner(System.in);
            try
            {
                System.out.println("What's your choice?");
                System.out.println("1.Visit a Bank");
                System.out.println("2.Shop");
                System.out.println("3.Exit");
                WorkingOn working = new WorkingOn();
                System.out.print("Your option : ");
                int option = in.nextInt();
                working.processing(option);
            }
            catch (Exception e)
            {
                System.out.println("Incorrect option.Please pick the option displayed above.");
            }
        }
}