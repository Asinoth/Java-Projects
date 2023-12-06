package csd.uoc.gr.controller;

import csd.uoc.gr.model.Player;
import csd.uoc.gr.model.card.Card;
import csd.uoc.gr.model.card.DealCard;
import csd.uoc.gr.model.card.MailCard;
import csd.uoc.gr.model.misc.Dice;
import csd.uoc.gr.model.position.*;
import csd.uoc.gr.view.GUI;
import csd.uoc.gr.view.PayDayCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

import static csd.uoc.gr.model.position.DealCardPosition.SpecialPositionType.buyer;
import static csd.uoc.gr.model.position.DealCardPosition.SpecialPositionType.deal;

public class Controller {

    public Player currentPlayer;
    public int maxGamePeriod;
    public int currentGamePeriod;
    public ArrayList<Player> game_players;
    public ArrayList<Position> Table;
    public Stack<Card> MailCardStack;
    public Stack<Card> DealCardStack;
    public PayDayCards pdv_utility;
    public GUI gui;
    public double jackpot_money;
    public int thisRoundsDice;

    public static void main(String[] args) {

        Controller game = new Controller();
        game.init(2);
    }


    /**
     * Initializes the game's table, player, cards and view
     */
    void init(int maxGamePeriod) {
        this.initPlayers();
        this.initTable();
        this.initCards();
        this.currentGamePeriod = 0;
        this.maxGamePeriod = maxGamePeriod;
        this.gui = new GUI(this);
        this.gui.update();
        this.jackpot_money = 100;
        this.thisRoundsDice = 0;
    }


    /**
     * Initializes the table positions with the appropriate class
     * pre-condition: empty game table
     * post-condition: game table with all 32 positions ready
     */
    void initTable() {
        this.Table = new ArrayList<>();
        ArrayList<Position> random_table = new ArrayList<>();
        Position p;
        for (int i = 0; i < 4; i++) {
            p = new MailCardPosition(1, this);
            p.setImagePath("images/mc1.png");
            random_table.add(p);
        }
        for (int i = 0; i < 4; i++) {
            p = new MailCardPosition(2, this);
            p.setImagePath("images/mc2.png");
            random_table.add(p);
        }
        for (int i = 0; i < 5; i++) {
            p = new DealCardPosition(deal, this);
            p.setImagePath("images/deal.png");
            random_table.add(p);
        }
        for (int i = 0; i < 2; i++) {
            p = new DicePosition();
            p.setImagePath("images/sweep.png");
            random_table.add(p);
        }
        for (int i = 0; i < 3; i++) {
            p = new DicePosition();
            p.setImagePath("images/lottery.png");
            random_table.add(p);
        }
        for (int i = 0; i < 2; i++) {
            p = new DicePosition();
            p.setImagePath("images/radio.png");
            random_table.add(p);
        }
        for (int i = 0; i < 6; i++) {
            p = new DealCardPosition(buyer, this);
            p.setImagePath("images/buyer.png");
            random_table.add(p);
        }
        for (int i = 0; i < 2; i++) {
            p = new DicePosition();
            p.setImagePath("images/casino.png");
            random_table.add(p);
        }
        for (int i = 0; i < 2; i++) {
            p = new DicePosition();
            p.setImagePath("images/yard.png");
            random_table.add(p);
        }
        Collections.shuffle(random_table);

        p = new Position() {
            @Override
            public void performAction(Player p) {
            }
        };
        p.setImagePath("images/start.png");
        this.Table.add(p);
        this.Table.addAll(random_table);

        p = new PaydayPosition();
        p.setImagePath("images/pay.png");
        this.Table.add(p);

        p = new SpecialPosition(SpecialPosition.SpecialPositionType.jackpot, this);
        p.setImagePath("images/jackpot.png");
        this.Table.add(p);

    }

    /**
     * Initializes the cards for every stack and shuffles them.
     * <p>
     * init every card's info along with its images
     * shuffle them and add them to the game's card stacks
     * <p>
     * pre-condition: empty card stack for MailCards and DealCards
     * post-condition: 2 shuffled stacks of (48)MailCards and (20)DealCards respectively (68 in total)
     */
    void initCards() {
        this.MailCardStack = new Stack<>();
        this.DealCardStack = new Stack<>();
        pdv_utility = new PayDayCards();
        pdv_utility.setVisible(false);
        pdv_utility.readFile("resources/dealCards_greeklish.csv", "Deal");
        pdv_utility.readFile("resources/mailCards_greeklish.csv", "Mail");
        for (int i = 0; i < pdv_utility.dealCards.length; i++) {
            this.DealCardStack.push(new DealCard(pdv_utility.dealCards[i][2], Double.parseDouble(pdv_utility.dealCards[i][3]), Double.parseDouble(pdv_utility.dealCards[i][4]), pdv_utility.dealCards[i][5], pdv_utility.dealCards[i][6], pdv_utility.dealCards[i][7]));
        }
        for (int i = 0; i < pdv_utility.mailCards.length; i++) {
            if (pdv_utility.mailCards[i][1].equals("Advertisement")) {
                this.MailCardStack.push(new MailCard(pdv_utility.mailCards[i][2], pdv_utility.mailCards[i][3], Double.parseDouble(pdv_utility.mailCards[i][4]), pdv_utility.mailCards[i][5], MailCard.MailType.Advertisment));
            } else if (pdv_utility.mailCards[i][1].equals("Bill")) {
                this.MailCardStack.push(new MailCard(pdv_utility.mailCards[i][2], pdv_utility.mailCards[i][3], Double.parseDouble(pdv_utility.mailCards[i][4]), pdv_utility.mailCards[i][5], MailCard.MailType.Bill));
            } else if (pdv_utility.mailCards[i][1].equals("Charity")) {
                this.MailCardStack.push(new MailCard(pdv_utility.mailCards[i][2], pdv_utility.mailCards[i][3], Double.parseDouble(pdv_utility.mailCards[i][4]), pdv_utility.mailCards[i][5], MailCard.MailType.Charity));
            } else if (pdv_utility.mailCards[i][1].equals("PayTheNeighbor")) {
                this.MailCardStack.push(new MailCard(pdv_utility.mailCards[i][2], pdv_utility.mailCards[i][3], Double.parseDouble(pdv_utility.mailCards[i][4]), pdv_utility.mailCards[i][5], MailCard.MailType.PayTheNeighbor));
            } else if (pdv_utility.mailCards[i][1].equals("MadMoney")) {
                this.MailCardStack.push(new MailCard(pdv_utility.mailCards[i][2], pdv_utility.mailCards[i][3], Double.parseDouble(pdv_utility.mailCards[i][4]), pdv_utility.mailCards[i][5], MailCard.MailType.MadMoney));
            } else if (pdv_utility.mailCards[i][1].equals("MoveToDealBuyer")) {
                this.MailCardStack.push(new MailCard(pdv_utility.mailCards[i][2], pdv_utility.mailCards[i][3], Double.parseDouble(pdv_utility.mailCards[i][4]), pdv_utility.mailCards[i][5], MailCard.MailType.MoveToDealBuyer));
            }

        }
        Collections.shuffle(this.MailCardStack);
        Collections.shuffle(this.DealCardStack);

    }

    /**
     * Initializes the players
     * pre-condition: empty game_players
     * post-condition: 2 Players with 3500 euro and 1 random player will play next
     */
    void initPlayers() {
        Random chaos = new Random();
        this.game_players = new ArrayList<Player>();
        this.game_players.add(new Player("Player1", 3500));
        this.game_players.add(new Player("Player2", 3500));
        int index = chaos.nextInt(this.game_players.size());
        this.currentPlayer = this.game_players.get(index);
    }

    /**
     * Simulates a dice throw and updates the view
     */
    public void guiThrowDice() {
        this.thisRoundsDice = Dice._throw();
        if(this.thisRoundsDice == 6){
            //jackpot
            this.Table.get(32).performAction(currentPlayer);
        }else{
            int steps = this.currentPlayer.getPosition_number() + this.thisRoundsDice;
            if (steps < 32) {
                this.currentPlayer.setPosition_number(steps);
            } else {
                this.currentPlayer.setPosition_number(31);
            }
        }

        this.gui.updateDice();
        System.out.println(this.currentPlayer.getPosition_number());
        this.player_round();
    }


    /**
     * Sets player's position, updates the view and performs the position's action
     */
    public void player_round() {

        this.gui.updatePlayerPositions();
        this.gui.update();
        int position = this.currentPlayer.getPosition_number();
//not yet
        this.Table.get(position).performAction(this.currentPlayer);
    }

    public double getScore() {
        return 0;
    }


    /**
     * Last day of the month.
     * Get +3500 euros
     * Pay bills
     * If a player is in the game's last month
     * -> we wait for the other player to end the last month too
     * If both players is in the game's last month
     * -> we check for winners based on getScore() for each player
     * If there is a winner
     * -> end game
     */
    public void payday() {

    }


    public boolean isFirstPlayerActive() {
        return this.game_players.get(0) == this.currentPlayer;
    }

    public boolean isSecondPlayerActive() {
        return this.game_players.get(1) == this.currentPlayer;
    }

    public void changeActivePlayer() {
        if (this.game_players.get(0) == this.currentPlayer) {
            this.currentPlayer = this.game_players.get(1);
        } else {
            this.currentPlayer = this.game_players.get(0);
        }
    }

    public Player getOpponent() {
        if (this.currentPlayer == this.game_players.get(0))
            return this.game_players.get(1);
        else
            return this.game_players.get(0);
    }

}
