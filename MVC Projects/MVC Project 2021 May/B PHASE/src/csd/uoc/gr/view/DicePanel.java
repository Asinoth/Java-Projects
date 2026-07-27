package csd.uoc.gr.view;

import javax.swing.*;
import java.awt.*;

public class DicePanel extends JPanel {
    ClassLoader cldr;

    public DicePanel() {
        this.cldr = this.getClass().getClassLoader();
    }

    public void updateDice(int num) {
        ImageIcon diceIcon = new ImageIcon(this.cldr.getResource("images/dice-" + num + ".jpg"));
        Image scaled_img = diceIcon.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
        this.removeAll();
        this.add(new JLabel(new ImageIcon(scaled_img)));
    }
}
