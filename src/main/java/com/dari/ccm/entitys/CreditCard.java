package com.dari.ccm.entitys;

public class CreditCard {
    private int id;
    private String cardName;
    private String cardHolderName;
    private String status;

    public CreditCard(int id, String cardName, String cardHolderName, String status) {
        this.id = id;
        this.cardName = cardName;
        this.cardHolderName = cardHolderName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", cardName='" + cardName + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
