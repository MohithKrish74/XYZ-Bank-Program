package com.keyword;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class AccountCreatingDetails
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
class BankCustomerInfo
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

    public int getId() {
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

class CustomerCredentials
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
class BankOperations
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

class WorkingOn
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
public class BankService {
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

