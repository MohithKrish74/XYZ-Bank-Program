package com.keyword;

import java.util.Scanner;

public class BankService {
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            try {
                System.out.println("\n1.Visit A Bank\n2.Visit A Shop\n3.Exit");
                System.out.print("Your Option : ");
                int option = in.nextInt();
                Bank bank = new Bank();
                if (option == 1) visitBank(bank);
                else if (option == 2) visitShop(bank);
                else {
                    System.out.println("Thank You.Please Visit Again!!!");
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Please enter the option in Integer Format!!!");
            }


        }
    }

    public static void visitBank(Bank bank) {
        Scanner in = new Scanner(System.in);
        System.out.println("1.Login\n2.Sign up");
        System.out.print("Your Option : ");
        int option = in.nextInt();
        if (option == 1) login(bank);
        else if (option == 2) signUp(bank);
    }

    public static void login(Bank bank) {
        Operations operations = new Operations();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the account number : ");
        int accountNumber = in.nextInt();
        if (bank.checkAccount(accountNumber)) {
            Account myAccount = bank.getAccount(accountNumber);
            System.out.println("Hi " + myAccount.getAccountOwner().getName() + " Welcome to XYZ Bank!!!");
            Inner:
            while (true) {
                System.out.println("\n1.Balance\n2.Deposit\n3.Withdraw\n4.Logout");
                System.out.print("Your Option : ");
                int option = in.nextInt();
                switch (option) {
                    case 1: {
                        operations.balance(myAccount);
                        break;
                    }
                    case 2: {
                        System.out.print("Enter the deposit amount : ");
                        double depositToBank = in.nextDouble();
                        operations.deposit(myAccount, depositToBank);
                        break;
                    }
                    case 3: {
                        System.out.print("Enter the withdraw amount : ");
                        double withdrawFromBank = in.nextDouble();
                        operations.withdraw(myAccount, withdrawFromBank);
                        break;
                    }
                    case 4: {
                        System.out.println("Logout Successfully!!!");
                        break Inner;
                    }
                }
            }
        } else {
            System.out.println("Account Number does not exists!!!");
        }
    }

    public static void signUp(Bank bank) {
        Scanner in = new Scanner(System.in);
        Card card = new Card();
        DebitCard debitCard = new DebitCard();
        CreditCard creditCard = new CreditCard();
        AccountGeneration numberGeneration = new AccountGeneration();
        System.out.println("Enter the signup details : ");
        System.out.print("Enter the name :");
        String name = in.next();
        System.out.print("Enter the age :");
        int age = in.nextInt();
        System.out.print("Enter the gender :");
        String gender = in.next();
        System.out.print("Enter the Minimum Balance :");
        double minBalance = in.nextDouble();
        User user = new User(name, age, gender);
        System.out.print("Do you want Credit Card (Y/N) ? ");
        String wantCreditCard = in.next();
        System.out.println("The Debit Details are :");
        numberGeneration.generatingAccountNumber();
        numberGeneration.generatingDebitCardNumber();debitCard.setCardNo(numberGeneration.debitCardNumber);
        numberGeneration.generatingDebitPinNumber();debitCard.setPinNo(numberGeneration.debitPinNumber);
        numberGeneration.generatingDebitCvvNumber();
        debitCard.setCvv(numberGeneration.debitCvvNumber);
        card.cardBrand();
        debitCard.setCardType("Debit");
        System.out.println("Card type : " + debitCard.getCardType());
        numberGeneration.generatingRandomDate();
        System.out.println("Debit Balance : " + minBalance);
        debitCard.setDebitBalance(minBalance);
        bank.addDebitAccount(numberGeneration.debitCardNumber, numberGeneration.debitPinNumber);
        bank.addDebitCredentials(debitCard);
        Account account = new Account(user, numberGeneration.accountNumber, minBalance);
        bank.addAccount(account);
        if (wantCreditCard.equals("Y") || wantCreditCard.equals("y")) {
            System.out.println("Credit Card Details : ");
            numberGeneration.generatingCreditCardNumber();creditCard.setCardNo(numberGeneration.creditCardNumber);
            numberGeneration.generatingCreditPinNumber();creditCard.setPinNo(numberGeneration.creditPinNumber);
            numberGeneration.generatingCreditCvvNumber();
            creditCard.setCvv(numberGeneration.creditCvvNumber);
            card.cardBrand();
            creditCard.setCardType("Credit");
            System.out.println("Card type : " + creditCard.getCardType());
            minBalance = ((minBalance > 500) ? minBalance + 1000 : minBalance + 500);
            creditCard.setCreditBalance(minBalance);
            numberGeneration.generatingRandomDate();
            System.out.println("Credit Balance : " + creditCard.getCreditBalance());
            creditCard.setCreditBalance(minBalance);
            bank.addCreditAccount(numberGeneration.debitCardNumber, numberGeneration.debitPinNumber);
            bank.addCreditCredentials(creditCard);
        }


    }

    public static void visitShop(Bank bank) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Credit and Debit Section !!!");
        System.out.print("Enter the card number : ");
        int cardNumber = in.nextInt();
        System.out.print("Enter the PIN number : ");
        int pinNumber = in.nextInt();
        if(bank.checkCreditOrDebitAccount(cardNumber,pinNumber)){
            debit(cardNumber,bank);
        }
        else System.out.println("Invalid Card number or Password!!!");
    }

    public static void debit(int cardNumber,Bank bank) {
        Scanner in = new Scanner(System.in);
        DebitCard myDebitAccount = bank.getDebitAccount(cardNumber);
        DebitCardOperations debitCardOperations = new DebitCardOperations();
        if(myDebitAccount.getDebitBalance()!=0.) {
            Inner:
            while (true) {
                System.out.println("\n1.Balance\n2.Deposit\n3.Swipe\n4.Logout");
                System.out.print("Your Option : ");
                int option = in.nextInt();
                switch (option) {
                    case 1: {
                        debitCardOperations.balance(myDebitAccount);
                        break;
                    }
                    case 2: {
                        System.out.print("Enter the deposit amount : ");
                        double depositToBank = in.nextDouble();
                        debitCardOperations.deposit(myDebitAccount, depositToBank);
                        break;
                    }
                    case 3: {
                        System.out.print("Enter the swipe amount : ");
                        double swipes = in.nextDouble();
                        debitCardOperations.swipe(myDebitAccount, swipes);
                        break;
                    }
                    case 4: {
                        System.out.println("Logout Successfully!!!");
                        break Inner;
                    }
                }
            }
        }
        else
        {
            credit(cardNumber,bank);
        }
    }

    public static void credit(int cardNumber,Bank bank) {
        Scanner in = new Scanner(System.in);
        CreditCard myCreditAccount = bank.getCreditAccount(cardNumber);
        CreditCardOperations creditCardOperations = new CreditCardOperations();
        if(myCreditAccount.getCreditBalance()!=0) {
            Inner:
            while (true) {
                System.out.println("\n1.Balance\n2.Deposit\n3.Withdraw\n4.Swipe\n5.Logout");
                System.out.print("Your Option : ");
                int option = in.nextInt();
                switch (option) {
                    case 1: {
                        creditCardOperations.balance(myCreditAccount);
                        break;
                    }
                    case 2: {
                        System.out.print("Enter the deposit amount : ");
                        double depositToBank = in.nextDouble();
                        creditCardOperations.deposit(myCreditAccount, depositToBank);
                        break;
                    }
                    case 3: {
                        System.out.print("Enter the withdraw amount : ");
                        double withdrawFromBank = in.nextDouble();
                        creditCardOperations.withdraw(myCreditAccount, withdrawFromBank);
                        break;
                    }
                    case 4: {
                        System.out.print("Enter the swipe amount : ");
                        double swipes = in.nextDouble();
                        creditCardOperations.swipe(myCreditAccount, swipes);
                        break;
                    }
                    case 5: {
                        System.out.println("Logout Successfully!!!");
                        break Inner;
                    }
                }
            }
        }
        else{
            System.out.println("Card number does not exists!!!");
        }
    }
}







