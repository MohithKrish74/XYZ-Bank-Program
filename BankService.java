package com.keyword;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

enum Options
{
    VISIT_A_BANK,
    VISIT_A_SHOP,
    EXIT
}

class Bank
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

class Account
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

class Operations {
    Bank bank = new Bank();
    public void balance() {
        System.out.println("Balance USD " + bank.balance);
    }
    public void deposit(double deposits) {
        bank.balance += deposits;
        System.out.println("Deposited Successfully!!!");
    }
    public void withdraw(double withdrawAmount) {
        double charges = 0;
        if (withdrawAmount % bank.CASH_WITHDRAWAL_MULTIPLE != 0) {
            System.out.println("Please correct the amount of value. It should be multiple of USD "+bank.CASH_WITHDRAWAL_MULTIPLE);
        } else {
            charges = ((withdrawAmount <= bank.MINIMUM_BALANCE) ? (bank.CHARGES * withdrawAmount) : (2 * withdrawAmount * bank.CHARGES));
            bank.balance = bank.balance - withdrawAmount - charges;
            if (bank.balance > withdrawAmount && bank.balance > bank.MINIMUM_BALANCE) {
                System.out.println("Charges USD " + charges);
                System.out.println("Withdrawn Successfully!!!");
            } else {
                System.out.println("Insufficient money in the account.Minimum balance in the bank should be USD 100. ");
            }
        }
    }
    public void swipe(double swipes)
    {
        if (swipes < bank.balance &&  (bank.balance - swipes) > bank.MINIMUM_BALANCE)
        {
            double cashBack;
            cashBack = (swipes * bank.CASHBACK) ;
            bank.balance = bank.balance - swipes + cashBack;
            System.out.println("CashBack " + cashBack);
            System.out.println("Cashback added Successfully!!!");
        }
        else
        {
            System.out.println("Swipe operations cannot be performed!!!");
        }
    }
}

class CreditAndDebit extends Operations {
        static int loginSuccessful = 1;
        static int credit = 1;
        double creditBalance;
        String nameOfCustomer;
        static Map<String, String> creditDetails = new HashMap<String, String>() ;
        static Map<String, String> creditNameFetch = new HashMap<String, String>();
        static Map<String, Double> creditBalanceList = new HashMap<String, Double>();
        static Map<String, String> debitDetails = new HashMap<String, String>() {{
            put("111", "1");
            put("222", "2");
        }};
        static Map<String, String> debitNameFetch = new HashMap<String, String>() {{
            put("111", "Ram");
            put("222", "Sam");
        }};
        static Map<String, Double> debitBalanceList = new HashMap<String, Double>() {{
            put("111", Bank.balanceList.get(("12345")));
            put("222", Bank.balanceList.get(("54321")));
        }};
        public boolean check(String cardNumber, String pinNumber) {
            if (creditDetails.containsKey(cardNumber) && creditDetails.get(cardNumber).equals(pinNumber)) {
                System.out.println("Hi " + creditNameFetch.get(cardNumber) + " welcome to XYZ Bank!!!");
                creditBalance = creditBalanceList.get(cardNumber);
                credit = 0;
                return true;
            }if (debitDetails.containsKey(cardNumber) && debitDetails.get(cardNumber).equals(pinNumber)) {
                System.out.println("Hi " + debitNameFetch.get(cardNumber) + " welcome to XYZ Bank!!!");
                Bank.balanceList.put(Bank.accountDebit.get(cardNumber),debitBalanceList.get(cardNumber));
                Bank.balance = debitBalanceList.get(cardNumber);//deb bal == bank bal
                nameOfCustomer = debitNameFetch.get(cardNumber);
                credit = 1;
                loginSuccessful = 1;
                return true;
            } else {
                System.out.println("No card number exists!!!");
                loginSuccessful = -1;
                return false;
            }
        }
        public void balance () {
            System.out.println("Balance USD " + creditBalance);
        }
        public void deposit ( double deposits){
            creditBalance += deposits;
            System.out.println("Deposited Successfully!!!");
        }
        public void withdraw ( double withdrawAmount){
            double charges;
            if (withdrawAmount % bank.CASH_WITHDRAWAL_MULTIPLE != 0) {
                System.out.println("Please correct the amount of value. It should be multiple of USD "+bank.CASH_WITHDRAWAL_MULTIPLE);
            } else {
                charges = ((withdrawAmount <= bank.MINIMUM_BALANCE) ? (bank.CHARGES * withdrawAmount) : (2 * withdrawAmount * bank.CHARGES));
                creditBalance = creditBalance - withdrawAmount - charges;
                if (creditBalance > withdrawAmount && creditBalance > bank.MINIMUM_BALANCE) {
                    System.out.println("Charges USD " + charges);
                    System.out.println("Withdrawn Successfully!!!");
                } else {
                    System.out.println("Insufficient money in the credit card!!! ");
                }
            }
        }
        public void swipe (double swipes)
        {
            if (swipes < creditBalance && (creditBalance - swipes) > bank.MINIMUM_BALANCE) {
                double cashBack;
                cashBack = (swipes * bank.CASHBACK);
                creditBalance = creditBalance - swipes + cashBack;
                System.out.println("CashBack " + cashBack);
                System.out.println("Cashback added Successfully!!!");
            } else {
                System.out.println("Swipe operations cannot be performed!!!");
            }
        }
    }
class Generating {
        Scanner in = new Scanner(System.in);
        int accountNumber = 0;
        String accountNumberString = Integer.toString(accountNumber);
        int debitCardNumber = 0;
        String debitCardNumberString = Integer.toString(debitCardNumber);
        int debitPinNumber=0;
        String debitPinNumberString = Integer.toString(debitPinNumber);
        int creditCardNumber = 0;
        String creditCardNumberString = Integer.toString(creditCardNumber);
        int creditPinNumber=0;
        String creditPinNumberString = Integer.toString(creditPinNumber);
        public void generatingAccountNumber() {
            while (!(Bank.account.containsKey(accountNumberString)) && !(accountNumberString.length() == 5)) {
                int min = 10000;
                int max = 99999;
                accountNumber = (int) (Math.random() * (max - min + 1) + min);
                accountNumberString = Integer.toString(accountNumber);
                break;
            }
            System.out.println("Account Number : " + accountNumberString);
        }
        public void generatingDebitCardNumber()
        {
            while (!(CreditAndDebit.debitDetails.containsKey(debitCardNumberString)&&!(debitCardNumberString.length() == 9))) {
                int min = 100000000;
                int max = 999999999;
                debitCardNumber = (int) (Math.random() * (max - min + 1) + min);
                debitCardNumberString = Integer.toString(debitCardNumber);
                break;
            }
            System.out.println("Debit Card Number : " + debitCardNumberString);
        }
        public void generatingDebitPinNumber()
        {
            int min = 1000;
            int max = 9999;
            debitPinNumber = (int)(Math.random()*(max-min+1)+min);
            debitPinNumberString = Integer.toString(debitPinNumber);
            System.out.println("Debit Card PIN Number : "+debitPinNumberString);
        }
        public void generatingCreditCardNumber()
        {
            while (!(CreditAndDebit.creditDetails.containsKey(creditCardNumberString)&&!(creditCardNumberString.length() == 9))) {
                int min = 100000000;
                int max = 999999999;
                creditCardNumber = (int) (Math.random() * (max - min + 1) + min);
                creditCardNumberString = Integer.toString(creditCardNumber);
                break;
            }
            System.out.println("Credit Card Number : " + creditCardNumberString);
        }
        public void generatingCreditPinNumber()
        {
            int min = 1000;
            int max = 9999;
            creditPinNumber = (int)(Math.random()*(max-min+1)+min);
            creditPinNumberString = Integer.toString(creditPinNumber);
            System.out.println("Credit Card PIN Number : "+creditPinNumberString);
        }
    }

public class BankService {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (true) {
                System.out.println();
                System.out.println("1.Visit a Bank\n2.Visit a Shop\n3.Exit");
                System.out.print("Your Option : ");
                Operations operations = new Operations();
                int option;
                try {
                    option = in.nextInt();
                    if (option == 1) {
                        System.out.println("1.Login\n2.Sign up");
                        System.out.print("Your Option : ");
                        int choice = in.nextInt();
                        if (choice == 1) {
                            Bank bank = new Bank();
                            System.out.print("Enter the account number : ");
                            int accountNumber = in.nextInt();
                            bank.checkAccount(Integer.toString(accountNumber));
                            if (bank.loginSuccessful == 1) {
                                Inner:
                                while (true) {
                                    switch (choice) {
                                        case 1: {
                                            System.out.println();
                                            System.out.println("1.Balance\n2.Deposit\n3.Withdraw\n4.Logout");
                                            System.out.print("Your Option : ");
                                            int userWish = in.nextInt();
                                            switch (userWish) {
                                                case 1: {
                                                    operations.balance();
                                                    break;
                                                }
                                                case 2: {
                                                    System.out.print("Enter the deposit amount : ");
                                                    double depositToBank = in.nextLong();
                                                    operations.deposit(depositToBank);
                                                    break;
                                                }
                                                case 3: {
                                                    System.out.print("Enter the withdraw amount : ");
                                                    double withdrawFromBank = in.nextLong();
                                                    operations.withdraw(withdrawFromBank);
                                                    break;
                                                }
                                                case 4: {
                                                    bank.balanceList.put(Integer.toString(accountNumber),bank.balance);
                                                    System.out.println("Logout Successfully!!!");
                                                    break Inner;
                                                } default:
                                                    System.out.println("Invalid Option!!!");
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println("Enter the Sign Up details :");
                            Account newAccount = new Account();
                            Generating numberGenerating = new Generating();
                            CreditAndDebit creditAndDebit = new CreditAndDebit();
                            System.out.print("Enter your Name : ");
                            String name = in.next();
                            System.out.print("Enter your Age : ");
                            int age = in.nextInt();
                            System.out.print("Enter your Gender : ");
                            String gender = in.next();
                            System.out.print("Enter the Deposit to the bank (Minimum Balance should be USD 100) :  ");
                            double minBalance = in.nextDouble();
                            System.out.print("Do you want Credit Card (Y/N) ? ");
                            String wantCreditCard = in.next();
                            newAccount.setName(name);
                            newAccount.setAge(age);
                            newAccount.setGender(gender);
                            newAccount.setMinBalance(minBalance);
                            System.out.println("The Details are : ");
                            newAccount.showDetails();
                            numberGenerating.generatingAccountNumber();
                            numberGenerating.generatingDebitCardNumber();
                            numberGenerating.generatingDebitPinNumber();
                            if(wantCreditCard.equals("Y")||wantCreditCard.equals("y")){
                                numberGenerating.generatingCreditCardNumber();
                                numberGenerating.generatingCreditPinNumber();
                            }
                            Bank.account.put(numberGenerating.accountNumberString, newAccount.getName());
                            Bank.balanceList.put(numberGenerating.accountNumberString, newAccount.getMinBalance());
                            creditAndDebit.debitDetails.put(numberGenerating.debitCardNumberString,numberGenerating.debitPinNumberString);
                            creditAndDebit.debitNameFetch.put(numberGenerating.debitCardNumberString, newAccount.getName());
                            creditAndDebit.debitBalanceList.put(numberGenerating.debitCardNumberString,minBalance);
                            creditAndDebit.creditDetails.put(numberGenerating.creditCardNumberString,numberGenerating.creditPinNumberString);
                            creditAndDebit.creditNameFetch.put(numberGenerating.creditCardNumberString, newAccount.getName());
                            creditAndDebit.creditBalanceList.put(numberGenerating.creditCardNumberString,
                                    (minBalance>500)?minBalance+1000:minBalance+500);
                        }
                    } else if (option == 2) {
                        CreditAndDebit creditAndDebit = new CreditAndDebit();
                        System.out.println("Welcome to Credit and Debit Section!!!");
                        System.out.print("Enter the card number : ");
                        int cardNumber = in.nextInt();
                        System.out.print("Enter the PIN number : ");
                        int pinNumber = in.nextInt();
                        creditAndDebit.check(Integer.toString(cardNumber), Integer.toString(pinNumber));
                        Inner1:
                        if (creditAndDebit.loginSuccessful == 1) {
                            while (true) {
                                System.out.println();
                                System.out.println("1.Balance\n2.Deposit\n3.Withdraw\n4.Swipe\n5.Create Credit\n6.Logout");
                                System.out.print("Your Option : ");
                                int select = in.nextInt();
                                if (select == 1) {
                                    if ((CreditAndDebit.credit == 0)) {
                                        creditAndDebit.balance();
                                    } else {
                                        operations.balance();
                                    }
                                } else if (select == 2) {
                                    System.out.print("Enter the deposit amount : ");
                                    double depositAmount = in.nextDouble();
                                    if ((CreditAndDebit.credit == 0)) {
                                        creditAndDebit.deposit(depositAmount);
                                    } else {
                                        operations.deposit(depositAmount);
                                    }
                                } else if (select == 3) {
                                    System.out.print("Enter the withdraw amount : ");
                                    double withdrawAmount = in.nextDouble();
                                    if ((CreditAndDebit.credit == 0)) {
                                        creditAndDebit.withdraw(withdrawAmount);
                                    } else {
                                        operations.withdraw(withdrawAmount);
                                    }
                                } else if (select == 4) {
                                    System.out.print("Enter the number of times you want to swipe : ");
                                    double swipes = in.nextDouble();
                                    if ((CreditAndDebit.credit == 0)) {
                                        creditAndDebit.swipe(swipes);
                                    } else {
                                        operations.swipe(swipes);
                                    }
                                }
                                else if (select == 5) {
                                    if(creditAndDebit.credit==1){
                                    Generating numberGenerating = new Generating();
                                    Account newAccount = new Account();
                                    if (!(creditAndDebit.creditNameFetch.containsValue(creditAndDebit.nameOfCustomer))) {
                                        numberGenerating.generatingCreditCardNumber();
                                        numberGenerating.generatingCreditPinNumber();
                                    } else {
                                        System.out.println("You have Credit Card already!!!");
                                    }
                                    creditAndDebit.creditDetails.put(numberGenerating.creditCardNumberString, numberGenerating.creditPinNumberString);
                                    creditAndDebit.creditNameFetch.put(numberGenerating.creditCardNumberString, creditAndDebit.nameOfCustomer);
                                    creditAndDebit.creditBalanceList.put(numberGenerating.creditCardNumberString,
                                            (Bank.balance > 500) ? Bank.balance + 1000 : Bank.balance + 500);
                                }
                                    else{
                                        System.out.println("You are in the Credit Card Section!!!.You have Credit Card already!!!");
                                    }
                                }
                                else if(select==6)
                                {
                                    Bank bank = new Bank();
                                    System.out.println("Logout Successfully!!! ");
                                    creditAndDebit.creditBalanceList.put(Integer.toString(cardNumber),creditAndDebit.creditBalance);
                                    creditAndDebit.debitBalanceList.put(Integer.toString(cardNumber),Bank.balance);
                                    Bank.balanceList.put(Bank.accountDebit.get(Integer.toString(cardNumber)),creditAndDebit.debitBalanceList.get(Integer.toString(cardNumber)));
                                    break Inner1;
                                }else{
                                    System.out.println("Invalid Option!!!");
                                }
                            }
                        }
                    } else {
                        System.out.println("Thank You.Please Visit Again!!!");
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println("Please enter the option in Integer format.Please try again!!!");
                    in.next();
                }
            }
        }
    }





