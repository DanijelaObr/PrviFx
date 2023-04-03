package com.example.cards;

public class Card {
    private int cardNumber;
    private String cardImage;

   public Card (String cardImage, int cardNumber) {
        this.cardImage = cardImage;
        this.cardNumber = cardNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardImage() {
        return cardImage;
    }

    public void setCardImage(String cardImage) {
        this.cardImage = cardImage;
    }
}
