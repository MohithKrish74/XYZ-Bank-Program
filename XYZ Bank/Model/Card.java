package com.keyword;

import java.util.Date;

public class Card
{
    int cardNo;
    int pinNo;
    int cvv;
    Date validity;
    String cardType;

    public void cardBrand()
    {
        System.out.println("Card Brand : Visa");
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setPinNo(int pinNo) {
        this.pinNo = pinNo;
    }

    public int getPinNo() {
        return pinNo;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getCvv() {
        return cvv;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public Date getValidity() {
        return validity;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }


}
