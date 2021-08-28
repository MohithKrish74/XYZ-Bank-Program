package com.keyword;

import java.util.Date;

public class CreditCard extends Card
{

    private int creditScore;
    private double creditBalance;

    public void setCardNo(int CardNo) { this.CardNo = CardNo; }

    public void setPinNo(int creditPinNo) { this.PinNo = creditPinNo; }

    public void setCvv(int cvv) { this.cvv = cvv; }

    public void setValidity(Date validity) { this.validity = validity; }

    public int getCardNo() {
        return CardNo;
    }

    public void setCardType(String creditCardType) { this.CardType = creditCardType; }



    public void setCreditScore(int creditScore) { this.creditScore = 1000; }

    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }

    public int getPinNo() {
        return PinNo;
    }

    public int getCvv() {
        return cvv;
    }

    public Date getValidity() {
        return validity;
    }

    public String getCardType() {
        return CardType;
    }



    public int getCreditScore() {
        return creditScore;
    }

    public double getCreditBalance() {
        return creditBalance;
    }
}
