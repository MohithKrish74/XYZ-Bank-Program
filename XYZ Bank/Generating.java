package com.keyword;

import java.util.GregorianCalendar;


public class Generating{
        Bank bank = new Bank();
        int accountNumber = 0;
        String accountNumberString = Integer.toString(accountNumber);
        int debitCardNumber = 0;
        String debitCardNumberString = Integer.toString(debitCardNumber);
        int debitPinNumber=0;
        int creditCardNumber = 0;
        String creditCardNumberString = Integer.toString(creditCardNumber);
        int creditPinNumber=0;
        int debitCvvNumber;
        int creditCvvNumber;
        public void generatingAccountNumber() {
        while (!(bank.checkAccount(accountNumber)) && !(accountNumberString.length() == 5)) {
                int min = 10000;
                int max = 99999;
                accountNumber = (int) (Math.random() * (max - min + 1) + min);
                accountNumberString = Integer.toString(accountNumber);
                break;
                }
                System.out.println("Account Number : " + accountNumber);
        }
        public void generatingDebitCardNumber()
        {
        while (!(Bank.creditDebitAccount.containsKey(debitCardNumber))&&!(debitCardNumberString.length() == 9)) {
                int min = 100000000;
                int max = 999999999;
                debitCardNumber = (int) (Math.random() * (max - min + 1) + min);
                break;
                }
                System.out.println("Debit Card Number : " + debitCardNumber);
        }
        public void generatingDebitPinNumber()
        {
                int min = 1000;
                int max = 9999;
                debitPinNumber = (int)(Math.random()*(max-min+1)+min);
                System.out.println("Debit Card PIN Number : "+debitPinNumber);
        }
        public void generatingCreditCardNumber()
        {
        while(!(Bank.creditDebitAccount.containsKey(creditCardNumber))&&!(creditCardNumberString.length() == 9)){
                int min = 100000000;
                int max = 999999999;
                creditCardNumber = (int) (Math.random() * (max - min + 1) + min);
                break;
                }
                System.out.println("Credit Card Number : " + creditCardNumber);
        }
        public void generatingCreditPinNumber()
        {
                int min = 1000;
                int max = 9999;
                creditPinNumber = (int)(Math.random()*(max-min+1)+min);
                System.out.println("Credit Card PIN Number : "+creditPinNumber);
        }
        public void generatingDebitCvvNumber()
        {
                int min = 100;
                int max = 999;
                debitCvvNumber = (int)(Math.random()*(max-min+1)+min);
                System.out.println("Debit Card CVV Number : "+debitCvvNumber);
        }
        public void generatingCreditCvvNumber()
        {
                int min = 100;
                int max = 999;
                creditCvvNumber = (int)(Math.random()*(max-min+1)+min);
                System.out.println("Credit Card CVV Number : "+creditCvvNumber);
        }

        public void generatingRandomDate() {
                GregorianCalendar gc = new GregorianCalendar();
                int year = randBetween(2021, 2050);
                gc.set(gc.YEAR, year);
                int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
                gc.set(gc.DAY_OF_YEAR, dayOfYear);
                System.out.println("Expiry Details : "+(gc.get(gc.MONTH) + 1) + "/" + gc.get(gc.YEAR) );

        }
        public int randBetween(int start, int end) {
                return start + (int)Math.round(Math.random() * (end - start));
                }

}
