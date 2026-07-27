package csd.uoc.gr.view;

import csd.uoc.gr.controller.Controller;
import csd.uoc.gr.model.card.DealCard;
import csd.uoc.gr.model.card.MailCard;
import csd.uoc.gr.model.position.DealCardPosition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class GUI extends JFrame {
    public Controller controller;
    private ClassLoader cldr;
    private JButton p2ThrowDiceButton;
    private JButton p2GetLoanButton;
    private JButton p1GetLoanButton;
    private JButton p1ThrowDiceButton;
    private JButton p1DealCardsButton;
    private JButton p1EndTurnButton;
    private JButton p2DealCardsButton;
    private JButton p2EndTurnButton;
    private DicePanel Dice2;
    private DicePanel Dice1;
    private JButton MailCardButton;
    private JButton DealCardButton;
    private JPanel ControlPanel;
    private JPanel Player2Panel;
    private JPanel InfoPanel;
    private JPanel Player1Panel;
    private JPanel BoardPanel;
    private JTextArea P1Info;
    private JPanel infoPanelText;
    private JTextArea GeneralInfo;
    private JPanel MainPanel;
    private JPanel P2InfoPanel;
    private JTextArea P2Info;
    private JPanel p1info;
    private PaydayLayeredPanel[] board;

    public GUI(Controller controller) {
        this.controller = controller;
        this.initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MainPanel.repaint();
        BoardPanel.setBackground(new Color(10, 128, 26));
        InfoPanel.setBackground(new Color(10, 128, 26));
        this.add(MainPanel);
        this.setPreferredSize(new Dimension(1280, 720));
        this.pack();
        this.setEnabled(true);
        this.setVisible(true);
        this.updatePlayerPositions();
    }

    /**
     * Updates the dice's icon
     */
    public void updateDice() {
        Dice1.updateDice(this.controller.thisRoundsDice);
        Dice2.updateDice(this.controller.thisRoundsDice);
    }

    public void enableDealCards() {
        this.MailCardButton.setEnabled(false);
        this.DealCardButton.setEnabled(true);
    }

    public void enableMailCards() {
        this.MailCardButton.setEnabled(true);
        this.DealCardButton.setEnabled(false);
    }


    /**
     * Update all pawns position
     */
    public void updatePlayerPositions() {
        this.initGuiTable();
        moveBluePawn(this.controller.game_players.get(0).getPosition_number());
        moveYellowPawn(this.controller.game_players.get(1).getPosition_number());
    }

    /**
     * Redraws every graphical component
     */
    public void update() {
        MailCardButton.setEnabled(false);
        DealCardButton.setEnabled(false);
        if (this.controller.isSecondPlayerActive()) {
            p1ThrowDiceButton.setEnabled(false);
            p1EndTurnButton.setEnabled(false);
            p1DealCardsButton.setEnabled(false);
            p1GetLoanButton.setEnabled(false);
            p2ThrowDiceButton.setEnabled(true);
            p2EndTurnButton.setEnabled(true);
            p2DealCardsButton.setEnabled(true);
            p2GetLoanButton.setEnabled(true);
        } else {
            p1ThrowDiceButton.setEnabled(true);
            p1EndTurnButton.setEnabled(true);
            p1DealCardsButton.setEnabled(true);
            p1GetLoanButton.setEnabled(true);
            p2ThrowDiceButton.setEnabled(false);
            p2EndTurnButton.setEnabled(false);
            p2DealCardsButton.setEnabled(false);
            p2GetLoanButton.setEnabled(false);
        }
        this.updatePlayerPositions();
        for (Component component : this.getComponents()) {
            component.repaint();
        }
        this.updateStats();
    }

    public void updateStats(){
        GeneralInfo.setText("CurrentPlayer: " + this.controller.currentPlayer.getName());
        P1Info.setText("P1 - Money:" + this.controller.game_players.get(0).getMoney() + ", \nBills:" + this.controller.game_players.get(0).getBills() + ", \nLoan:" + this.controller.game_players.get(0).getLoan());
        P2Info.setText("P2 - Money:" + this.controller.game_players.get(1).getMoney() + ", \nBills:" + this.controller.game_players.get(1).getBills() + ", \nLoan:" + this.controller.game_players.get(1).getLoan());
    }


    public void moveBluePawn(int position_number) {
        URL imageUrl = cldr.getResource("images/pawn_blue.png");
        JPanel layer = new JPanel();
        ImageIcon newImgIcon = new ImageIcon(imageUrl);
        Image newImg = newImgIcon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        JLabel ImgLabel = new JLabel(new ImageIcon(newImg));
        ImgLabel.setOpaque(false);
        ImgLabel.setIcon(new ImageIcon(newImg));
        ImgLabel.setSize(40, 100);

        layer.add(ImgLabel);
        layer.setBounds(5, 30, 35, 50);
        layer.setOpaque(false);
        this.board[position_number].add(layer, JLayeredPane.POPUP_LAYER);
    }

    public void moveYellowPawn(int position_number) {
        URL imageUrl = cldr.getResource("images/pawn_yellow.png");
        JPanel layer = new JPanel();
        ImageIcon newImgIcon = new ImageIcon(imageUrl);
        Image newImg = newImgIcon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        JLabel ImgLabel = new JLabel(new ImageIcon(newImg));
        ImgLabel.setOpaque(false);
        ImgLabel.setIcon(new ImageIcon(newImg));
        ImgLabel.setSize(30, 100);

        layer.add(ImgLabel);
        layer.setBounds(45, 30, 35, 50);
        layer.setOpaque(false);
        this.board[position_number].add(layer, JLayeredPane.POPUP_LAYER);
    }

    private void initGuiTable() {
        for (int i = 0; i < this.board.length; i++) {
            URL imageURL = cldr.getResource(this.controller.Table.get(i).getImagePath());
            this.board[i].removeAll();
            this.board[i].addPaydayImageComponent(imageURL, JLayeredPane.DEFAULT_LAYER);
            this.board[i].setPreferredSize(new Dimension(100, 100));
        }
        this.pack();
    }

    private void initComponents() {
        this.cldr = this.getClass().getClassLoader();
        this.board = new PaydayLayeredPanel[33];
        for (int i = 0; i < this.board.length; i++) {
            this.board[i] = new PaydayLayeredPanel();
        }
        this.initGuiTable();


        MainPanel = new JPanel();
        MainPanel.setLayout(new BorderLayout(0, 0));
        ControlPanel = new JPanel();
        ControlPanel.setLayout(new BorderLayout(0, 0));
        MainPanel.add(ControlPanel, BorderLayout.EAST);
        Player1Panel = new JPanel();
        Player1Panel.setLayout(new GridBagLayout());
        ControlPanel.add(Player1Panel, BorderLayout.NORTH);
        p1GetLoanButton = new JButton();
        p1GetLoanButton.addActionListener(new LoanButtonActionListener(this));
        p1GetLoanButton.setText("Get Loan");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Player1Panel.add(p1GetLoanButton, gbc);
        p1ThrowDiceButton = new JButton();
        p1ThrowDiceButton.setText("Roll Dice");
        p1ThrowDiceButton.addActionListener(new DiceButtonActionListener(this));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Player1Panel.add(p1ThrowDiceButton, gbc);
        p1DealCardsButton = new JButton();
        p1DealCardsButton.setText("My Deal Cards");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Player1Panel.add(p1DealCardsButton, gbc);
        p1EndTurnButton = new JButton();
        p1EndTurnButton.setText("End Turn");
        p1EndTurnButton.addActionListener(new EndTurnButtonActionListener(this));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Player1Panel.add(p1EndTurnButton, gbc);
        Dice1 = new DicePanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.WEST;
        Player1Panel.add(Dice1, gbc);
        InfoPanel = new JPanel();
        InfoPanel.setLayout(new GridBagLayout());
        ControlPanel.add(InfoPanel, BorderLayout.CENTER);
        MailCardButton = new JButton();
        URL imageUrl = this.cldr.getResource("images/mailCard.png");
        MailCardButton.addActionListener(new MailCardDrawActionListener(this));
        MailCardButton.setIcon(new ImageIcon((new ImageIcon(imageUrl).getImage().getScaledInstance(110, 70, Image.SCALE_SMOOTH))));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        InfoPanel.add(MailCardButton, gbc);
        DealCardButton = new JButton();
        imageUrl = this.cldr.getResource("images/dealCard.png");
        DealCardButton.addActionListener(new DealCardDrawActionListener(this));
        DealCardButton.setIcon(new ImageIcon((new ImageIcon(imageUrl).getImage().getScaledInstance(110, 70, Image.SCALE_SMOOTH))));

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        InfoPanel.add(DealCardButton, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        Player2Panel = new JPanel();
        Player2Panel.setLayout(new GridBagLayout());
        ControlPanel.add(Player2Panel, BorderLayout.SOUTH);
        p2ThrowDiceButton = new JButton();
        p2ThrowDiceButton.addActionListener(new DiceButtonActionListener(this));
        p2ThrowDiceButton.setText("Roll Dice");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Player2Panel.add(p2ThrowDiceButton, gbc);
        p2GetLoanButton = new JButton();
        p2GetLoanButton.addActionListener(new LoanButtonActionListener(this));
        p2GetLoanButton.setText("Get Loan");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Player2Panel.add(p2GetLoanButton, gbc);
        p2DealCardsButton = new JButton();
        p2DealCardsButton.setText("My Deal Cards");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Player2Panel.add(p2DealCardsButton, gbc);
        p2EndTurnButton = new JButton();
        p2EndTurnButton.setText("End Turn");
        p2EndTurnButton.addActionListener(new EndTurnButtonActionListener(this));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Player2Panel.add(p2EndTurnButton, gbc);
        p1info = new JPanel();
        p1info.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        Player1Panel.add(p1info, gbc);

        P1Info = new JTextArea();
        P1Info.setFocusable(false);
        P1Info.setColumns(21);
        P1Info.setRows(5);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        p1info.add(P1Info, gbc);
        Dice2 = new DicePanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.WEST;
        Player2Panel.add(Dice2, gbc);
        BoardPanel = new JPanel();
        BoardPanel.setLayout(new GridBagLayout());
        MainPanel.add(BoardPanel, BorderLayout.CENTER);
        infoPanelText = new JPanel();
        infoPanelText.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        InfoPanel.add(infoPanelText, gbc);
        GeneralInfo = new JTextArea();
        GeneralInfo.setFocusable(false);
        GeneralInfo.setColumns(21);
        GeneralInfo.setRows(10);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        infoPanelText.add(GeneralInfo, gbc);
        P2InfoPanel = new JPanel();
        P2InfoPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        Player2Panel.add(P2InfoPanel, gbc);
        P2Info = new JTextArea();
        P2Info.setFocusable(false);
        P2Info.setColumns(21);
        P2Info.setRows(5);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        P2InfoPanel.add(P2Info, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[0], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[1], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[2], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[3], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[4], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[5], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[6], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[7], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[8], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[9], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[10], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[11], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[12], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[13], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[14], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[15], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[16], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[17], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[18], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[19], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[20], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[21], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[22], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[23], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[24], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[25], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[26], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[27], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[28], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[29], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[30], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[31], gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        BoardPanel.add(board[32], gbc);
    }

    /**
     * Activates the LoanDialog and updates the user's interface
     */
    private class LoanButtonActionListener implements ActionListener {
        GUI gui;

        public LoanButtonActionListener(GUI gui) {
            this.gui = gui;
        }

        public void actionPerformed(ActionEvent e) {
            String m = JOptionPane.showInputDialog("Loan money:");
            if (Double.parseDouble(m) % 1000 != 0) {
                System.err.println("\nCan't loan money that's not multiple of 1000");
                return;
            }
            this.gui.controller.currentPlayer.setLoan(this.gui.controller.currentPlayer.getLoan() + Double.parseDouble(m));
            JButton button = (JButton) e.getSource();
            button.setEnabled(false);
            this.gui.updateStats();
        }
    }

    /**
     * Throws the dice using the controller's function and updates the user's interface
     */
    private class DiceButtonActionListener implements ActionListener {
        GUI gui;

        public DiceButtonActionListener(GUI gui) {
            this.gui = gui;
        }

        public void actionPerformed(ActionEvent e) {
            this.gui.initGuiTable();
            this.gui.controller.guiThrowDice();
            JButton button = (JButton) e.getSource();
            button.setEnabled(false);
        }
    }

    /**
     * Changes the behaviour of buttons
     * for the previous player and activate the buttons for the active player and updates the user's interface
     */
    private class EndTurnButtonActionListener implements ActionListener {
        GUI gui;

        public EndTurnButtonActionListener(GUI gui) {
            this.gui = gui;
        }

        public void actionPerformed(ActionEvent e) {
            this.gui.controller.changeActivePlayer();
            this.gui.DealCardButton.setEnabled(false);
            this.gui.MailCardButton.setEnabled(false);
            this.gui.update();
        }
    }

    /**
     * Activates the CardDialogs and updates the user's interface
     */
    private class DealCardDrawActionListener implements ActionListener {
        GUI gui;

        public DealCardDrawActionListener(GUI gui) {
            this.gui = gui;
        }

        public void actionPerformed(ActionEvent e) {
            DealCard c = (DealCard) this.gui.controller.DealCardStack.pop();
            if (this.gui.controller.pdv_utility.showDealCard(c.getNumber()) == 0) {
                if (c.getCost() <= this.gui.controller.currentPlayer.getMoney()) {
                    this.gui.controller.currentPlayer.subtractMoney(c.getCost());

                    this.gui.controller.currentPlayer.addCard(c);
                } else {
                    System.err.println("Balance not sufficient");
                }
            }
            this.gui.DealCardButton.setEnabled(false);
            this.gui.update();
        }
    }

    private class MailCardDrawActionListener implements ActionListener {
        GUI gui;

        public MailCardDrawActionListener(GUI gui) {
            this.gui = gui;
        }

        public void actionPerformed(ActionEvent e) {
            MailCard c = (MailCard) this.gui.controller.MailCardStack.pop();
            if (this.gui.controller.pdv_utility.showMailCard(c.getNumber()) == 0) {
                //accepted
                if (c.getMailType() == MailCard.MailType.Advertisment) {
                    this.gui.controller.currentPlayer.addMoney(c.getEuro());
                } else if (c.getMailType() == MailCard.MailType.Bill) {
                    this.gui.controller.currentPlayer.subtractMoney(c.getEuro());
                } else if (c.getMailType() == MailCard.MailType.Charity) {
                    this.gui.controller.currentPlayer.subtractMoney(c.getEuro());
                    this.gui.controller.jackpot_money += c.getEuro();
                } else if (c.getMailType() == MailCard.MailType.PayTheNeighbor) {
                    this.gui.controller.currentPlayer.subtractMoney(c.getEuro());
                    this.gui.controller.getOpponent().addMoney(c.getEuro());
                } else if (c.getMailType() == MailCard.MailType.MadMoney) {
                    this.gui.controller.getOpponent().subtractMoney(c.getEuro());
                    this.gui.controller.currentPlayer.addMoney(c.getEuro());
                } else if (c.getMailType() == MailCard.MailType.MoveToDealBuyer) {
                    for (int i = this.gui.controller.currentPlayer.getPosition_number(); i < this.gui.controller.Table.size(); i++) {
                        if (this.gui.controller.Table.get(i) instanceof DealCardPosition) {
                            this.gui.controller.currentPlayer.setPosition_number(i);
                        }
                    }
                }
            }
            this.gui.MailCardButton.setEnabled(false);
            this.gui.update();
        }
    }

}
