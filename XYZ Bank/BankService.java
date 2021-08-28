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
                if (option == 1) visitBank();
                else if (option == 2) visitShop();
                else {
                    System.out.println("Thank You.Please Visit Again!!!");
                    System.exit(0);
                }
            }
            catch (Exception e)
            {
                System.out.println("Please enter the option in Integer Format!!!");
            }


        }
    }

    public static void visitBank() {
        Bank bank = new Bank();
        Scanner in = new Scanner(System.in);
        System.out.println("1.Login\n2.Sign up");
        System.out.print("Your Option : ");
        int option = in.nextInt();
        if (option == 1) login();
        else if (option == 2) signUp();
    }

    public static void login() {
        Bank bank = new Bank();
        Operations operations = new Operations();
        DebitCard debitCard = new DebitCard();
        CreditCard creditCard = new CreditCard();
        User user1 = new User("Ram", 25,"M");
        User user2 = new User("Sam", 25,"M");
        Account account1 = new Account(user1, 12345, 100., "Ram");
        Account account2 = new Account(user2, 54321, 150., "Sam");
        debitCard.setCardNo(111);
        debitCard.setPinNo(1);
        account1.setDebitCard(debitCard);
        bank.addAccount(account1);
        debitCard.setCardNo(22);
        debitCard.setPinNo(2);
        account2.setDebitCard(debitCard);
        bank.addAccount(account2);
        creditCard.setCardNo(111);
        creditCard.setPinNo(1);
        account1.setCreditCard(creditCard);
        bank.addAccount(account1);
        creditCard.setCardNo(222);
        creditCard.setPinNo(2);
        account1.setCreditCard(creditCard);
        bank.addAccount(account2);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the account number : ");
        int accountNumber = in.nextInt();
        if (bank.checkAccount(accountNumber)) {
            Account myAccount = bank.getAccount(accountNumber);
            System.out.println("Hi " + myAccount.getAccountHolderName() + " Welcome to XYZ Bank!!!");
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

    public static void signUp() {
        Scanner in = new Scanner(System.in);
        Bank bank = new Bank();
        Card card = new Card();
        DebitCard debitCard = new DebitCard();
        CreditCard creditCard = new CreditCard();
        Generating numberGenerating = new Generating();
        System.out.println("Enter the signup details : ");
        System.out.print("Enter the name :");
        String name = in.next();
        System.out.print("Enter the age :");
        int age = in.nextInt();
        System.out.print("Enter the gender :");
        String gender = in.next();
        System.out.print("Enter the Minimum Balance :");
        double minBalance = in.nextDouble();
        User user = new User(name, age,gender);
        System.out.print("Do you want Credit Card (Y/N) ? ");
        String wantCreditCard = in.next();
        System.out.println("The Debit Details are :");
        numberGenerating.generatingAccountNumber();
        numberGenerating.generatingDebitCardNumber();debitCard.setCardNo(numberGenerating.debitCardNumber);
        numberGenerating.generatingDebitPinNumber();debitCard.setPinNo(numberGenerating.debitPinNumber);
        numberGenerating.generatingDebitCvvNumber();debitCard.setCvv(numberGenerating.debitCvvNumber);
        card.cardBrand();debitCard.setCardType("Debit");
        System.out.println("Card type : " + debitCard.getCardType());
        numberGenerating.generatingRandomDate();
        System.out.println("Debit Balance : " + minBalance);
        Bank.debitBalanceList.put(numberGenerating.debitCardNumber, minBalance);
        bank.addDebitAccount(numberGenerating.debitCardNumber, numberGenerating.debitPinNumber);
        if (wantCreditCard.equals("Y") || wantCreditCard.equals("y")) {
            System.out.println("Credit Card Details : ");
            numberGenerating.generatingCreditCardNumber();creditCard.setCardNo(numberGenerating.creditCardNumber);
            numberGenerating.generatingCreditPinNumber();creditCard.setPinNo((numberGenerating.creditPinNumber));
            numberGenerating.generatingCreditCvvNumber();creditCard.setCvv(numberGenerating.creditCvvNumber);
            card.cardBrand();creditCard.setCardType("Credit");
            System.out.println("Card type : " + creditCard.getCardType());
            minBalance = ((minBalance > 500) ? minBalance + 1000 : minBalance + 500);
            creditCard.setCreditBalance(minBalance);
            numberGenerating.generatingRandomDate();
            System.out.println("Credit Balance : " + creditCard.getCreditBalance());
            Bank.creditBalanceList.put(numberGenerating.creditCardNumber, minBalance);
            bank.addCreditAccount(numberGenerating.creditCardNumber, numberGenerating.creditPinNumber);
        }
        new Account(user, numberGenerating.accountNumber, minBalance, name);

    }

    public static void visitShop() {
        Scanner in = new Scanner(System.in);
        Bank bank = new Bank();
        DebitCard debitCard = new DebitCard();
        CreditCard creditCard = new CreditCard();
        bank.addDebitAccount(111, 1);
        bank.addDebitAccount(222, 2);
        bank.addCreditAccount(100, 1);
        bank.addCreditAccount(200, 2);
        User user1 = new User("Ram", 24,"M");
        Account account1 = new Account(user1, 12345, 100., "Ram");
        bank.addDebitAccount(111, 1);
        bank.addDebitAccount(222, 2);
        bank.addCreditAccount(100, 1);
        bank.addCreditAccount(200, 2);
        debitCard.setCardNo(111);
        debitCard.setPinNo(1);
        account1.setDebitCard(debitCard);
        creditCard.setCardNo(100);
        creditCard.setPinNo(1);
        account1.setCreditCard(creditCard);
        Bank.creditBalanceList.put(100, 600.);
        Bank.creditBalanceList.put(200, 100.);
        Bank.debitBalanceList.put(111,600.);
        Bank.debitBalanceList.put(222,500.);
        System.out.println("Welcome to Credit and Debit Section !!!");
        System.out.print("Enter the card number : ");
        int cardNumber = in.nextInt();
        System.out.print("Enter the PIN number : ");
        int pinNumber = in.nextInt();
        bank.checkDebitOrCreditAccount(cardNumber, pinNumber);


    }

    public static void credit(int cardNumber, double creditBalance) {
        Scanner in = new Scanner(System.in);
        Bank bank = new Bank();
        CreditCardOperations creditCardOperations = new CreditCardOperations();

        Inner:
        while (true) {
            System.out.println("\n1.Balance\n2.Deposit\n3.Withdraw\n4.Swipe\n5.Logout");
            System.out.print("Your Option : ");
            int option = in.nextInt();
            switch (option) {
                case 1: {
                    creditCardOperations.balance(cardNumber);
                    break;
                }
                case 2: {
                    System.out.print("Enter the deposit amount : ");
                    double depositToBank = in.nextDouble();
                    creditCardOperations.deposit(cardNumber, depositToBank);
                    break;
                }
                case 3: {
                    System.out.print("Enter the withdraw amount : ");
                    double withdrawFromBank = in.nextDouble();
                    creditCardOperations.withdraw(cardNumber, withdrawFromBank);
                    break;
                }
                case 4: {
                    System.out.print("Enter the number of swipes : ");
                    double swipes = in.nextDouble();
                    creditCardOperations.swipe(cardNumber, swipes);
                    break;
                }
                case 5: {
                    System.out.println("Logout Successfully!!!");
                    Bank.creditBalanceList.put(cardNumber,creditBalance);
                    break Inner;
                }
                default:
                    System.out.println("Invalid Option!!!");
            }
        }

    }

    public static void debit(int cardNumber) {
        Scanner in = new Scanner(System.in);
        DebitCardOperations debitCardOperations = new DebitCardOperations();
        Inner:
        while (true) {
            System.out.println("\n1.Balance\n2.Deposit\n3.Withdraw\n4.Swipe\n5.Logout");
            System.out.print("Your Option : ");
            int option = in.nextInt();
            switch (option) {
                case 1: {
                    debitCardOperations.balance(cardNumber);
                    break;
                }
                case 2: {
                    System.out.print("Enter the deposit amount : ");
                    double depositToBank = in.nextDouble();
                    debitCardOperations.deposit(cardNumber, depositToBank);
                    break;
                }
                case 3: {
                    System.out.print("Enter the withdraw amount : ");
                    double withdrawFromBank = in.nextDouble();
                    debitCardOperations.withdraw(cardNumber, withdrawFromBank);
                    break;
                }
                case 4: {
                    System.out.print("Enter the number of swipes : ");
                    double swipes = in.nextDouble();
                    debitCardOperations.swipe(cardNumber, swipes);
                    break;
                }
                case 5: {
                    System.out.println("Logout Successfully!!!");
                    Bank.debitBalanceList.put(cardNumber,Bank.debitBalanceList.get(cardNumber));
                    break Inner;
                }
                default:
                    System.out.println("Invalid Option!!!");
            }
        }

    }
}

