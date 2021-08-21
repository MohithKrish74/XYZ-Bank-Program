package com.keyword;

import java.util.Scanner;

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
                    System.out.println("Welcome to Credit and Debit");
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
                            else if (select == 5)
                            {
                                Generating numberGenerating = new Generating();
                                Account newAccount = new Account();
                                numberGenerating.generatingCreditCardNumber();
                                numberGenerating.generatingCreditPinNumber();
                                creditAndDebit.creditDetails.put(numberGenerating.creditCardNumberString,numberGenerating.creditPinNumberString);
                                creditAndDebit.creditNameFetch.put(numberGenerating.creditCardNumberString,creditAndDebit.nameOfCustomer);
                                creditAndDebit.creditBalanceList.put(numberGenerating.creditCardNumberString,
                                        (Bank.balance>500)?Bank.balance+1000:Bank.balance+500);
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




