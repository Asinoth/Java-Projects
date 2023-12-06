package csd.uoc.gr.A24.guiClient;

/*
 * @author: Yannis Tzitzikas
 * Context: CS252, 2019-2010, Computer Science Department, University of Crete
 */

import java.awt.Image;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


import model.classes.Card;

import model.classes.ProductSugar;
import model.classes.ProductSeller;
import model.classes.Coin;
import model.classes.DrinkProduct;
import model.classes.Product;
import model.interfaces.ProductSeller_ADT;

/*
 * The class APPLICATION simulates (through a GUI) the physical part of a product selling machine.
 * It sends and receives messages to the Model part of the application. 
 * (the model part of the application does not depend on the gui).
 */

// CoinButton can hold a reference to a Coin
// We define it as a class for creating buttons for several coins easily

class CoinButton extends JButton implements ActionListener {
	Coin  c; 
	public void actionPerformed (ActionEvent e) { // called on click
		System.out.println(c);
		APPLICATION.cseller.insertCoin(c); // calls the corresponding method of the model
		APPLICATION.updateDisplay();   // updates the display
        APPLICATION.updateDisplayOfSystemActions(APPLICATION.cseller.getLog());
        APPLICATION.cseller.clearLog(); // clears the log
     }			
	CoinButton(Coin c) {
		super(c.toString());
		this.c = c;
		this.addActionListener(this);	// for managing itself the clicks
	}
	
	CoinButton(Coin c, String imagePath){ // coin with icon
        this(c); // calls the previous constructor

        //Adds the image to the button
        Image newimg = new ImageIcon(imagePath).getImage().getScaledInstance(
                45, 45, java.awt.Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(newimg));
	}
}

//CardButton can hold a reference to a Card
class CardButton extends JButton implements ActionListener {
    Card c;
    
    @Override
    public void actionPerformed(ActionEvent e) {
		System.out.println(c);
		APPLICATION.cseller.insertCard(c); // calls the corresponding method of the model
		APPLICATION.updateDisplay();   // updates the display
        APPLICATION.updateDisplayOfSystemActions(APPLICATION.cseller.getLog());
        APPLICATION.cseller.clearLog();
    }
    
    CardButton(Card c) {
        super("Insert Card");
        this.c = c;
        this.addActionListener(this);
    }
    
    CardButton(Card c, String imgPath) {
        this(c); // calls the previous constructor

        //Adds the image to the button
        Image newimg = new ImageIcon(imgPath).getImage().getScaledInstance(
                70, 30, java.awt.Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(newimg));
    }
}


//ProductButton can hold a reference to a Product
//We define it as a class for creating buttons for several kinds of products
class ProductButton extends JButton implements ActionListener {
	Product   t; 
	public void actionPerformed (ActionEvent e) {
		System.out.println(t);
		APPLICATION.cseller.selectProduct(t);  // calls the corresponding method of the model
		APPLICATION.updateDisplay();
     }			
	ProductButton(Product t) {
		super(t.toString());
		this.t = t;
		this.addActionListener(this);
	}
    
    ProductButton(Product t, String imagePath) {
        this(t);
        this.setIcon(new ImageIcon(imagePath));
    }
}


//SugarButton can hold a reference to a ProductSugar objec
//We define it as a class for creating buttons for several kinds of product sugars
class SugarButton extends JButton implements ActionListener {
	ProductSugar   cs; 
	public void actionPerformed (ActionEvent e) {
		System.out.println(cs);
		APPLICATION.cseller.selectProductSugar(cs);  // calls the corresponding method of the model
		APPLICATION.updateDisplay();
   }
    
	SugarButton(ProductSugar cs) {
		super(cs.toString());
		this.cs = cs;
		this.addActionListener(this);
	}
    
    SugarButton(ProductSugar cs, String imagePath) {
        this(cs);
        this.setIcon(new ImageIcon(imagePath));
    }
}


// This the class with the main that starts the application
public class APPLICATION extends JFrame {
    private final int initWaterStock = 5;  // default 
    private final int initCupsStock = 5;   // default
    private final float initCardAmmount = 50F; //in euro
    
	static final String appName = "PRODUCT SELLER  MACHINE  v0.1 Application (Oct. 2019)";
	
	static ProductSeller_ADT cseller;   // only one instance is needed   
	
    static ArrayList<CoinButton> coinButtons;   //arraylist holding all the coin buttons
    static CardButton cardButton;               //button for inserting the card
	static ProductButton 
		    tsaiB, xamomhliB, dictamB,
			greekCoffeeB, freddoEspressoB, freddoCappuccinoB; // coffee buttons
	static SugarButton sketos, metrios, glykos; // coffee sugar buttons
	static JButton cancelButton; // the cancel button
	static JButton finishButton; // the finish button
	static JLabel  displayArea;  // for displaying the status
	static JLabel  actionLog;  // for displaying the log of actions
	
	
	// it creates all coin buttons (it puts them in a panel)
	void createCoinButtons() {
		
		JPanel coinPanel = new JPanel(new GridLayout(2,3,5,5)); // rows, columns, int hgap, int vgap)
		coinPanel.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Pay by Coins"));
		
        String coinImgPath = "resources/images";
        coinButtons = new ArrayList<>();
        coinButtons.add(new CoinButton(new Coin("2 Euro", 2F), coinImgPath+"/two_euro.png"));
		coinButtons.add(new CoinButton(new Coin("1 Euro", 1F), coinImgPath+"/one_euro.png"));
        coinButtons.add(new CoinButton(new Coin("50 cents", 0.5F), coinImgPath+"/fifty_cents.png"));
        coinButtons.add(new CoinButton(new Coin("20 cents", 0.2F), coinImgPath+"/twenty_cents.png"));
        coinButtons.add(new CoinButton(new Coin("10 cents", 0.1F), coinImgPath+"/ten_cents.png"));
        coinButtons.add(new CoinButton(new Coin("5 cents", 0.05F), coinImgPath+"/five_cents.png"));
            
        for(CoinButton b : coinButtons)
            coinPanel.add(b);
        
		add(coinPanel); // adds the panel to this frame
	}
	
	
	// it creates all card related buttons (and puts them in a panel)
	void createCardButtons() {
		JPanel cardPanel = new JPanel(new GridLayout(1,3,5,5)); // rows, columns, int hgap, int vgap)
		cardPanel.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Pay by Card"));
		
		cardButton = new CardButton(new Card(initCardAmmount), "resources/images/coffee_card.png");
		cardPanel.add(cardButton);
		
		add(cardPanel); // adds the panel to this frame
	}
		
	// it creates all product buttons and puts them in a panel
	void createProductButtons() {
		
		JPanel productPanel = new JPanel(new GridLayout(2,3,5,5)); // rows, columns, int hgap, int vgap)
		productPanel.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Products"));
		
		tsaiB = new ProductButton(new DrinkProduct("Tea", 0.6F));
		productPanel.add(tsaiB); 
		
		xamomhliB = new ProductButton(new DrinkProduct("Chamomile", 0.6F));
		productPanel.add(xamomhliB);
		
		dictamB = new ProductButton(new DrinkProduct("Dictam", 0.6F));
		productPanel.add(dictamB);
		
		greekCoffeeB = new ProductButton(new DrinkProduct("Greek", 1F), "resources/images/greek_coffee.png");
		productPanel.add(greekCoffeeB);
		
        freddoEspressoB = new ProductButton(new DrinkProduct("Freddo Espresso", 1.5F), "resources/images/freddo_espresso.png");
        productPanel.add(freddoEspressoB);
        
		freddoCappuccinoB = new ProductButton(new DrinkProduct("Freddo Cappuccino", 2.0F), "resources/images/freddo_cappucino.png");
		productPanel.add(freddoCappuccinoB);
		
		add(productPanel);
	}
	
    //it creates all the product sugar options and put them in a panel
	void createProductOptionsButtons() {
		
		JPanel sugarPanel = new JPanel(new GridLayout(1,3,5,5)); // rows, columns, int hgap, int vgap)
		sugarPanel.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Sugar"));

		
        sketos = new SugarButton(ProductSugar.Katholou, "resources/images/sugar_free.png");
        sugarPanel.add(sketos);
        
        metrios= new SugarButton(ProductSugar.MiaKoutalia, "resources/images/white_sugar_1.png");
        sugarPanel.add(metrios);
        
		glykos= new SugarButton(ProductSugar.DyoKoutalies, "resources/images/white_sugar_2.png");
		sugarPanel.add(glykos);
		
		add(sugarPanel);
	}
	
	// creates the rest buttons (card, cancel, finish) and put them in a panel
	void createCancelFinishButtons() {
			
		JPanel commandPanel = new JPanel(new GridLayout(1,3,5,5)); // rows, columns, int hgap, int vgap)
		commandPanel.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Commands"));
		
        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.RED);
        cancelButton.setContentAreaFilled(false);
        cancelButton.setOpaque(true);
        
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println("Cancel");
                APPLICATION.cseller.cancel();  // calls the corresponding method of the model
                APPLICATION.updateDisplay();
                updateDisplayOfSystemActions(APPLICATION.cseller.getLog());
                cseller.clearLog();
            }
        });
        commandPanel.add(cancelButton);
        
        finishButton = new JButton("Finish");
        finishButton.setBackground(Color.green);
        finishButton.setContentAreaFilled(false);
        finishButton.setOpaque(true);
        
        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println("Finish");
                APPLICATION.cseller.finish();  // calls the corresponding method of the model
                APPLICATION.updateDisplay();
                updateDisplayOfSystemActions(APPLICATION.cseller.getLog());
                cseller.clearLog();
            }
        });
        commandPanel.add(finishButton);
        
		add(commandPanel); // adds this panel to this jframe
	}
	
	// it creates the Display and the Log area (and put them in a panel).
	void createDisplayAndLogButtons() {
		
		JPanel displayPanel = new JPanel(new GridLayout(1,3,5,5)); // rows, columns, int hgap, int vgap)
		displayPanel.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Display and Log"));
		
		// A: DISPLAY
        displayArea = new JLabel("STATUS");
        displayArea.setVerticalAlignment(SwingConstants.TOP);
        displayArea.setBackground(Color.white);
        displayArea.setOpaque(true);  
        displayArea.setForeground (Color.blue);
        
                
        JScrollPane scrollerDisplay = new JScrollPane(displayArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        displayPanel.add(scrollerDisplay); 
        
        add(displayPanel); // adds this panel to this jframe

        // B: Action Log
        actionLog = new JLabel("WELCOME");
        actionLog.setVerticalAlignment(SwingConstants.TOP);
        actionLog.setBackground(Color.lightGray);
        actionLog.setOpaque(true);  
        JScrollPane scroller = new JScrollPane(actionLog, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        displayPanel.add(scroller); 
        
        add(displayPanel); // adds this panel to this jframe
	}
	
	
	static void updateDisplay() {
		displayArea.setText(cseller.getFullState());
	}
	
	static void updateDisplayOfSystemActions(String s) {
		actionLog.setText(s);
	}

	APPLICATION(){
		// CORE PART
		cseller = new ProductSeller(initWaterStock,initCupsStock);
				
		// GUI PART: size, layout, title
		setBounds(100,100,824,850);  //x,  y,  width,  height)
		setLayout(new GridLayout(7,3,5,5)); // rows, columns, int hgap, int vgap)
		setVisible(true);
		setTitle(appName);
		
		// GUI PART:  calling the methods that create buttons each in one separate panel
        createProductButtons();
        createProductOptionsButtons();
		createCoinButtons();
		createCardButtons();
		createCancelFinishButtons();
        createDisplayAndLogButtons();
		
		setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
	}
	
	public static void main(String[] args) {
		System.out.println(appName);
        APPLICATION app = new APPLICATION();
	}
}
