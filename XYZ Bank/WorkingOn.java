package com.keyword;

import java.util.Scanner;

public class WorkingOn
{
    Scanner in = new Scanner(System.in);
    public void processing(int option)
    {
        switch (option)
        {
            case 1: {
                System.out.println("Do you have an account?");
                System.out.print("Enter Y or y for Yes, N or n for No : ");
                String haveAccount = in.next();
                System.out.println("1.Login");
                System.out.println("2.Sign up");
                System.out.print("Your option : ");
                int choices = in.nextInt();
                if (choices == 1) {
                    System.out.println("Enter the Login Credentials : ");
                    AccountCreatingDetails creatingDetails = new AccountCreatingDetails();
                    CustomerCredentials credentials = new CustomerCredentials();
                    System.out.print("Enter the ID : ");
                    int id = in.nextInt();
                    credentials.setId(id);
                    System.out.print("Enter the Account number : ");
                    String accountNumber = in.next().trim();
                    credentials.setAccountNumber(accountNumber);
                    BankCustomerInfo customerInfo = new BankCustomerInfo();
                    int loginSuccessful = -1;
                    if (customerInfo.userId.containsKey(id))
                    {
                        if (customerInfo.userId.get(id).equals(accountNumber))
                        {

                            System.out.println("Hi " + customerInfo.userName.get(accountNumber) + " welcome to XYZ Bank!!!");
                            loginSuccessful = 1;
                        }
                        else
                        {
                            System.out.println("Incorrect Account Number or Id.");
                            System.exit(0);
                        }
                    }
                    else
                    {
                        System.out.println("Account number does not exists!!!");
                        System.exit(0);
                    }
                    if (loginSuccessful == 1) {
                        while (true) {
                            System.out.println();
                            System.out.println("What is your choice ?");
                            System.out.println("1.Balance");
                            System.out.println("2.Deposit");
                            System.out.println("3.Withdraw");
                            System.out.println("4.Swipe");
                            System.out.println("5.Logout");
                            System.out.print("Your choice : ");
                            int choice = in.nextInt();
                            switch (choice) {
                                case 1: {
                                    BankOperations operations = new BankOperations();
                                    operations.balance();
                                    break;
                                }
                                case 2: {
                                    BankOperations operations = new BankOperations();
                                    System.out.print("Enter the deposit amount : ");
                                    double depositToBank = in.nextDouble();
                                    operations.deposit(depositToBank);
                                    break;
                                }
                                case 3: {
                                    BankOperations operations = new BankOperations();
                                    System.out.print("Enter the withdrawal amount : ");
                                    double withdrawFromBank = in.nextDouble();
                                    operations.withdraw(withdrawFromBank);
                                    break;
                                }
                                case 4: {
                                    BankOperations operations = new BankOperations();
                                    System.out.print("Enter the number of times you want to Swipe : ");
                                    double numberOfSwipes = in.nextDouble();
                                    operations.swipe(numberOfSwipes);
                                    break;
                                }
                                case 5: {
                                    System.out.println("Logout Successfully!!!");
                                    System.out.println("Thank You.Please Visit Again!!!");
                                    System.exit(0);

                                }
                            }
                        }
                    }
                }
                else if (choices == 2)
                {
                    System.out.println("Enter Signup Credentials : ");
                    BankService.generatingAccountNumber();
                }

            }
            case 2:
            {
                System.out.println("1.CREDIT");
                System.out.println("2.DEBIT");
                System.out.print("Your option :  ");
                int opt = in.nextInt();
                if(opt==1)
                {
                    System.out.println("1.REFRESH");
                    System.out.println("2.SHOP");
                    System.out.print("Your option : ");
                    int select = in.nextInt();
                    if(select==1)
                    {
                        System.out.println("Credit Restored Successfully!!!");
                        System.exit(0);
                    }
                    else
                    {
                        CreditAndDebit card = new CreditAndDebit();
                        card.withdraw();
                        break;

                    }
                }
                else
                {
                    CreditAndDebit card = new CreditAndDebit();
                    card.withdraw();
                    break;

                }
            }
            case 3:
            {
                System.out.println("Thank You.Please Visit Again!!!");
                System.exit(0);
            }
        }
    }
}

class CreditAndDebit extends WorkingOn
{
    Scanner in = new Scanner(System.in);
    public void withdraw()
    {
        BankOperations operations = new BankOperations();
        WorkingOn working = new WorkingOn();
        System.out.print("Enter the account number : ");
        String accountNumberForCard = in.next();
        if(BankCustomerInfo.userName.containsKey(accountNumberForCard))
        {
            System.out.println("Hi "+BankCustomerInfo.userName.get(accountNumberForCard)+" welcome to XYZ Bank!!!");
            System.out.print("Enter the withdrawal amount : ");
            double withdrawal = in.nextDouble();
            System.out.print("Enter the number of swipes : ");
            double numberOfSwipes = in.nextDouble();
            operations.withdraw(withdrawal);
            operations.swipe(numberOfSwipes);
            operations.balance();
            System.out.println("Thank You.Please Visit Again!!!");
        }

    }

}
