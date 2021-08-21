package com.keyword;

import java.util.Scanner;


public class Generating{
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

