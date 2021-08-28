package com.keyword;

import java.util.Date;

public class DebitCard extends Card
{

    public void setCardNo(int CardNo) { this.CardNo = CardNo; }

    public void setPinNo(int creditPinNo) { this.PinNo = creditPinNo; }

    public void setCvv(int cvv) { this.cvv = cvv; }

    public void setValidity(Date validity) { this.validity = validity; }

    public int getCardNo() {
        return CardNo;
    }

    public void setCardType(String creditCardType) { this.CardType = creditCardType; }

    public int getCreditPinNo() {
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



}
