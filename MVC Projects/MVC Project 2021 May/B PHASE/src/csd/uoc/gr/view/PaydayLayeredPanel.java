package csd.uoc.gr.view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PaydayLayeredPanel extends JLayeredPane {


    public PaydayLayeredPanel() {

    }

    public void addPaydayImageComponent(URL imageUrl, Integer layer_index) {
        JPanel layer = new JPanel();
        ImageIcon newImgIcon = new ImageIcon(imageUrl);
        Image newImg = newImgIcon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        JLabel ImgLabel = new JLabel(new ImageIcon(newImg));
        ImgLabel.setOpaque(true);
        ImgLabel.setIcon(new ImageIcon(newImg));
        ImgLabel.setPreferredSize(new Dimension(100, 100));
        layer.add(ImgLabel);
        layer.setBounds(0, 0, 100, 100);
        layer.setOpaque(false);
        this.add(layer, layer_index);
    }


}
