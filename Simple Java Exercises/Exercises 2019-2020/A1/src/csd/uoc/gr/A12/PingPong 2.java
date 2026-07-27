package csd.uoc.gr.A12;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;
import org.jfugue.*;




class Utilities
{
	private static Player p = new Player();
	public static void sound(String s)
	{
		
		p.play(s);
		
	}
}






class Ping 

{
	
	public static void ping(int k)
	{
		StringBuilder sb = new StringBuilder("Ping" + " " + "[" + k + "]" + " " + "[" + (k+3) + "]" + " " + "[" + (k+7) + "]");
		
		
		String tester = sb.subSequence(6, 8).toString();
		int a = Integer.parseInt(tester);
		
		if(a % 2 == 0)
			sb.insert(5, "I[FLUTE] ");
		else
			sb.insert(5, "I[SYNTH_STRINGS_1] ");
		String res = sb.substring(5);
		System.out.println(sb);
		Utilities p = new Utilities();
		p.sound(res);
		
		if(k < 100)
			Pong.pong(k+3);
	}


	public static void main(String args[])

	{
	
		ping(40);

	}
	 
	 

}

class Pong 
{
	
	
	
	public static void pong(int k)
	{
StringBuilder sb = new StringBuilder("Pong" + " " + "[" + k + "]" + " " + "[" + (k+4) + "]" + " " + "[" + (k+7) + "]");
		
		
		String tester = sb.subSequence(6, 8).toString();
		int a = Integer.parseInt(tester);
		if(a % 2 == 0)
			sb.insert(5, "I[TUBA] ");
		else
			sb.insert(5, "I[CHOIR_AAHS] ");
		
		String res = sb.substring(5);
		System.out.println(sb);
		Utilities p = new Utilities();
		p.sound(res);
		if(k < 100)
			Ping.ping(k+3);
	}


	public static void main(String args[])
	{
		
		pong(40);
		
	}

}


class SimpleEqualizer {

    static int heightPer;
    static String text = "";
    static JFrame application = new JFrame();

    public SimpleEqualizer() {

        application.setTitle("SimpleGraph EQ");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                /* 
                    Values for intializing/centering the eq bars.
                    Bars have different X coordinates(pingRectX, pongRectX) and same Y(commonY), width(commonW) and height(commonH) values.
                    Value currentH contains modified height based on k(provided by the user through setBar(..)).
                 */
                int pingRectX = getSize().width / 8;
                int pongRectX = getSize().width - 3 * getSize().width / 8;

                int commonY = getSize().height / 6;
                int commonW = getSize().width / 4;

                double commonH = getSize().height - commonY;
                double currentH = (getSize().height - (double) SimpleEqualizer.heightPer / 100 * commonH);

                /*
                    Drawing x-axis and y-axis.
                    drawLine(x1, y1, x2, y2) draws a line from (x1,y1) to (x2, y2)
                 */
                g.setFont(new Font("default", Font.BOLD, 22));
                g.drawLine(getSize().width / 2, getSize().height / 10, getSize().width / 2, getSize().height - 2);
                g.drawLine(getSize().width / 10, getSize().height - 2, getSize().width - getSize().width / 10, getSize().height - 2);


                /*
                    fillRect(x:coordinate, y:coordinate, width, height) "draws" and fills a rectangle.
                    drawString(text, x1, y1) draws "text" in (x1,y1).
                 */
                if (!text.equals("")) {
                    if (text.equals("PING")) {
                        g.drawString("PING", getSize().width / 4, getSize().height / 10);

                        g.setColor(new Color(132, 93, 93));
                        g.fillRect(pingRectX, (int) currentH, commonW, (int) (getSize().height - currentH - 2));

                        //percentage of height
                        g.drawString("  " + SimpleEqualizer.heightPer + "%(" + (int) currentH + ")", getSize().width / 2, (int) currentH);

                    } else if (text.equals("PONG")) {
                        g.drawString("PONG", getSize().width - getSize().width / 4, getSize().height / 10);

                        g.setColor(new Color(132, 93, 93));
                        g.fillRect(pongRectX, (int) currentH, commonW, (int) (getSize().height - currentH - 2));

                        //percentage of height
                        g.drawString("  " + SimpleEqualizer.heightPer + "%(" + (int) currentH + ")", getSize().width / 2, (int) currentH);

                    }
                }
            }
        });

        application.setPreferredSize(new Dimension(1200, 750));
        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);

    }

    public void setBar(String text, int heightPer) {
        SimpleEqualizer.text = text;
        SimpleEqualizer.heightPer = heightPer;

        application.repaint();

    }

}

