package csd.uoc.gr.model;

import csd.uoc.gr.model.card.Card;

import java.util.ArrayList;

public class Player {


    String name;
    double money;
    double bills;
    double loan;
    ArrayList<Card> cards;
    int position_number;

    public Player(String name, double money) {
        this.name = name;
        this.money = money;
        this.position_number = 0;
        this.bills = 0;
        this.cards = new ArrayList<>();
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getLoan() {
        return loan;
    }

    public void setBills(double bills) {
        this.bills = bills;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition_number(int position_number) {
        this.position_number = position_number;
    }

    public double getMoney() {
        return money;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public double getBills() {
        return bills;
    }

    public int getPosition_number() {
        return position_number;
    }

    public String getName() {
        return name;
    }

    public void addMoney(double money) {
        this.setMoney(this.money + money);
    }

    public void subtractMoney(double money) {
        this.setMoney(this.money - money);
    }
}


