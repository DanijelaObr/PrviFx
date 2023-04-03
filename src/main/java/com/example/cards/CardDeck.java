package com.example.cards;


import com.example.utill.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private List<Card> cardDeck = new ArrayList<Card>();

    protected List<String> cards = new ArrayList<>();
    protected FileReader fileReader = new FileReader();
    protected Card card1;
    protected Card card2;
    protected Card card3;
    protected Card card4;
    protected Card specialCard;

    public CardDeck() {
        createCards();
        this.addCards(card1, 1);
        this.addCards(card2, 1);
        this.addCards(card3, 1);
        this.addCards(card4, 1);
        this.addCards(specialCard, 0);
        this.shuffle();
    }

    public List<Card> getCardDeck() {
        return cardDeck;
    }

    public void setCardDeck(List<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }


    public void addCards(Card card, int flag) {
        int i;
        if (flag == 0) {
            i = 12;
        } else i = 10;

        for (int j = 0; j < i; j++) {
            cardDeck.add(card);
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cardDeck);
    }

    public void createCards() {
        cards = fileReader.readImageSources("src/main/resources/cards/cards-paths.txt");
        card1 = new Card(cards.get(0), 1);
        card2 = new Card(cards.get(1), 2);
        card3 = new Card(cards.get(2), 3);
        card4 = new Card(cards.get(3), 4);
        specialCard = new Card(cards.get(4), 0);

    }
}
