package com.keyword;

import java.util.Date;

public class Card
{
    int CardNo;
    int PinNo;
    int cvv;
    Date validity;
    String CardType;

    public void cardBrand()
    {
        System.out.println("Card Brand : Visa");
    }

   /* public void setCardNo(int cardNo) {
        CardNo = cardNo;
    }

    public int getCardNo() {
        return CardNo;
    }

    public void setPinNo(int pinNo) {
        PinNo = pinNo;
    }

    public int getPinNo() {
        return PinNo;
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
        CardType = cardType;
    }

    public String getCardType() {
        return CardType;
    }

    public void setCardBrand(String cardBrand) {
        CardBrand = cardBrand;
    }

    public String getCardBrand() {
        return CardBrand;
    }*/
}
