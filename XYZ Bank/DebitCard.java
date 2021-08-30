package com.keyword;

import java.util.Date;

public class DebitCard extends Card
{

    public void setCardNo(int cardNo) { this.cardNo = cardNo; }

    public void setPinNo(int creditPinNo) { this.pinNo = creditPinNo; }

    public void setCvv(int cvv) { this.cvv = cvv; }

    public void setValidity(Date validity) { this.validity = validity; }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardType(String creditCardType) { this.cardType = creditCardType; }

    public int getCreditPinNo() {
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



}
