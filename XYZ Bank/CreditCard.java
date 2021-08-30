package com.keyword;

import java.util.Date;

public class CreditCard extends Card
{

    private int creditScore;
    private double creditBalance;

    public void setCardNo(int cardNo) { this.cardNo = cardNo; }

    public void setPinNo(int creditPinNo) { this.pinNo = creditPinNo; }

    public void setCvv(int cvv) { this.cvv = cvv; }

    public void setValidity(Date validity) { this.validity = validity; }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardType(String creditCardType) { this.cardType = creditCardType; }



    public void setCreditScore(int creditScore) { this.creditScore = 1000; }

    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }

    public int getPinNo() {
        return pinNo;
    }

    public int getCvv() {
        return cvv;
    }

    public Date getValidity() {
        return validity;
    }

    public String getCardType() {
        return cardType;
    }



    public int getCreditScore() {
        return creditScore;
    }

    public double getCreditBalance() {
        return creditBalance;
    }
}
