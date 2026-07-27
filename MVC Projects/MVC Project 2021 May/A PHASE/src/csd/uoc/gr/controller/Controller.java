package csd.uoc.gr.controller;

import csd.uoc.gr.model.Player;
import csd.uoc.gr.model.card.Card;
import csd.uoc.gr.model.misc.Dice;
import csd.uoc.gr.model.position.Position;
import csd.uoc.gr.view.GUI;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Controller {

    public Player currentPlayer;
    public int maxGamePeriod;
    public int currentGamePeriod;
    public ArrayList<Player> game_players;
    public ArrayList<Position> Table;
    public Stack<Card> MailCardStack;
    public Stack<Card> DealCardStack;
    GUI gui;
    public static void main(String[] args) {

        Controller game = new Controller();
        game.init();
    }


    /**
     * Initializes the game's table, player, cards and view
     */
    void init(){
        initPlayers();
        initTable();
        initCards();
        this.currentGamePeriod = 0;
        this.gui = new GUI();
    }


    /**
     * Initializes the table positions with the appropriate class
     * pre-condition: empty game table
     * post-condition: game table with all 32 positions ready
     */
    void initTable(){
        this.Table = new ArrayList<>();
    }

    /**
     * Initializes the cards for every stack and shuffles them
     * pre-condition: empty card stack for MailCards and DealCards
     * post-condition: 2 shuffled stacks of (48)MailCards and (20)DealCards respectively (68 in total)
     */
    void initCards(){
        this.MailCardStack = new Stack<>();
        this.DealCardStack = new Stack<>();
//        init every card's info along with its images
//        load 8 for each kind of card
//        shuffle them and add them to the game's card stacks
    }

    /**
     * Initializes the players
     * pre-condition: empty game_players
     * post-condition: 2 Players with 3500 euro and 1 random player will play next
     */
    void initPlayers(){
        Random chaos = new Random();
        this.game_players = new ArrayList<Player>();
        this.game_players.add(new Player("Player1",3500));
        this.game_players.add(new Player("Player2",3500));
        int index = chaos.nextInt(this.game_players.size());
        this.currentPlayer = this.game_players.get(index);
    }

    /**
     * Simulates a dice throw and updates the view
     */
    int throwDice(){
        int steps = Dice._throw();
        this.gui.setDice(steps);
        return steps;
    }

    /**
     * Sets player's position, updates the view and performs the position's action
     */
    public void player_round(){
        int steps = this.throwDice();
        this.gui.setPlayerPosition(this.currentPlayer,steps);
        this.gui.update();
        int position = this.currentPlayer.getPosition_number();
        this.Table.get(position).performAction(this.currentPlayer);
    }

    public double getScore(){
        return 0;
    }


    /**
     * Last day of the month.
     * Get +3500 euros
     * Pay bills
     * If a player is in the game's last month
     *      -> we wait for the other player to end the last month too
     * If both players is in the game's last month
     *      -> we check for winners based on getScore() for each player
     * If there is a winner
     *      -> end game
     *
     */
    public void payday(){

    }

}
