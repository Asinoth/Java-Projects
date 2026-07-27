package View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraphicUI extends JFrame {

	 private Image image;
	    private JButton PlayCards;
	    private JButton PlayButton,newGame;
	    private JButton Move_Cards_to_on_The_Track;
	    private JButton My_Destination_Tickets;
	    private JButton My_Big_Cities_Bonus_Cards;
	   
	    private JDesktopPane player1_field;
	    private JDesktopPane player1_field2;
	   
	    private JPanel jPanel1;
	    private JTextField jTextField1;
	    private URL imageURL;
	    private ClassLoader cldr;  
	    private JButton[] buttons = new JButton[100];
	    
	    
	    
	    
	    /**
		 * <b>constructor</b>: Creates a new Window and initializes some buttons and panels <br />
		 * <b>postconditions</b>: Creates a new Window and initializes some buttons and panels
		 * starting a new game.
		 */
	    public GraphicUI() {
	        
	   
	        
	    }
	   
	    
	    /**
		 * <b>transformer(mutative)</b>:initializes some buttons and labels <br />
		 * <p><b>Postcondition:</b> initializes some buttons and labels </p>
		 *
	     */
	    private void initComponents() {
	      
	    }
	        
	    /**
		 * <b>transformer(mutative)</b>:sets some buttons and labels for a new deal<br />
		 * <p><b>Postcondition:</b> sets some buttons and labels for a new deal </p>
		 *
	     */
	    
	   
	  /* a class which is used for putting a background image to a jdesktoppane*/  
	public class myDesktopPane extends JDesktopPane
	{
	   private Image backImage = null;
	 
	   public myDesktopPane()
	   {      
	      
	   }
	 
	        @Override
	   public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		}
	 } 
	/* a class which is used for doing some action after a card button has been pushed */  
	 private class CardListener implements ActionListener 	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	
	  
	                    
	                    
	 }

}
