package csd.uoc.gr.A11;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

public class Drawagraphic extends Frame
{
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
				{
					g2.setColor(Color.black);	
					Font font = new Font("Brush Script MT Italic", Font.ITALIC, 78);
					g2.setFont(font);
					g2.drawString("A", 240, 250);
					
				}
		
	}
	
	void drawAgraphic()
	{
		setSize(400, 400);
		setVisible(true);
		
		
	}
	
	public static void main(String [] args)
	{
		Drawagraphic d = new Drawagraphic();
		d.setSize(600, 400);
		d.setVisible(true);
		
		
		
	}
}