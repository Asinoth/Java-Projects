package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import Controller.Controller;




import javax.swing.JMenuBar;
import javax.swing.JButton;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

import javax.swing.JToolBar;

import java.awt.Label;

import javax.swing.ImageIcon;

import java.awt.SystemColor;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.util.Random;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class GraphicsUi extends JFrame {
	Controller info= new Controller();
	Random rand = new Random();
	public int pathtest1;
	public int pathtest2;
	public int pathtest3;
	public int pathtest4;
	public int pathtest5;
	public int pathtest6;
	public int pathtest7;
	public int pathtest8;
	public int pathtest9;
	public int pathtest10;
	public int pathtest11;
	public int pathtest12;
	public int pathtest13;
	public int pathtest14;
	public int pathtest15;
	public int pathtest16;
	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=51,-1
	 */
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicsUi frame = new GraphicsUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GraphicsUi() {
		
		setTitle("anazhthsh anakatorwn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setToolTipText("anazhthsh anaktorwn");
		contentPane.setBorder(new LineBorder(Color.GREEN));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//label for the pawn of player
		final JLabel lblNewLabel_5 = new JLabel("p1 pioni");
		lblNewLabel_5.setIcon(new ImageIcon(GraphicsUi.class.getResource("/pionia/arch.jpg")));
		lblNewLabel_5.setVisible(false);
		
		//label for the pawn of player
		final JLabel lblPPioni = new JLabel("p1 pioni 2");
		lblPPioni.setIcon(new ImageIcon(GraphicsUi.class.getResource("/pionia/arch.jpg")));
		lblPPioni.setVisible(false);
		
		//label for the pawn of player
		final JLabel lblPPioni_1 = new JLabel("p1 pioni 3");
		lblPPioni_1.setIcon(new ImageIcon(GraphicsUi.class.getResource("/pionia/arch.jpg")));
		lblPPioni_1.setVisible(false);
		
		//label for the pawn of player
		final JLabel lblPlayerHero = new JLabel("player 1 hero");
		lblPlayerHero.setVisible(false);
		
		//label for the pawn of player
		final JLabel lblPPioni_4 = new JLabel("p2 pioni");
		lblPPioni_4.setVisible(false);
		lblPPioni_4.setIcon(new ImageIcon(GraphicsUi.class.getResource("/pionia/arch.jpg")));
		lblPPioni_4.setBounds(126, 475, 47, 25);
		contentPane.add(lblPPioni_4);
		
		//label for the pawn of player
		final JLabel lblPHero = new JLabel("p2 hero");
		lblPHero.setVisible(false);
		lblPHero.setIcon(new ImageIcon(GraphicsUi.class.getResource("/pionia/theseus.jpg")));
		lblPHero.setBounds(127, 417, 47, 25);
		contentPane.add(lblPHero);
		
		//label for the pawn of player
		final JLabel lblPPioni_3 = new JLabel("p2 pioni");
		lblPPioni_3.setVisible(false);
		lblPPioni_3.setIcon(new ImageIcon(GraphicsUi.class.getResource("/pionia/arch.jpg")));
		lblPPioni_3.setBounds(126, 362, 47, 25);
		contentPane.add(lblPPioni_3);
		
		//label for the pawn of player
		final JLabel lblPPioni_2 = new JLabel("p2 pioni");
		lblPPioni_2.setVisible(false);
		lblPPioni_2.setIcon(new ImageIcon(GraphicsUi.class.getResource("/pionia/arch.jpg")));
		lblPPioni_2.setBounds(127, 307, 47, 25);
		contentPane.add(lblPPioni_2);
		lblPlayerHero.setIcon(new ImageIcon(GraphicsUi.class.getResource("/pionia/theseus.jpg")));
		lblPlayerHero.setBounds(126, 475, 47, 25);
		contentPane.add(lblPlayerHero);
		lblPPioni_1.setBounds(126, 417, 47, 25);
		contentPane.add(lblPPioni_1);
		lblPPioni.setBounds(126, 362, 47, 25);
		contentPane.add(lblPPioni);
		lblNewLabel_5.setBounds(127, 307, 47, 25);
		contentPane.add(lblNewLabel_5);
		//label for the start choose random player
		String turn="turn of player "+info.start();
		JLabel lblSad = new JLabel(turn);
		lblSad.setVerticalAlignment(SwingConstants.TOP);
		lblSad.setForeground(Color.CYAN);
		lblSad.setFont(new Font("Stencil", Font.PLAIN, 11));
		lblSad.setBackground(Color.WHITE);
		lblSad.setBounds(10, 504, 124, 25);
		contentPane.add(lblSad);
		
		//debck button
		JButton btnNewButton = new JButton("Deck");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setIcon(new ImageIcon(GraphicsUi.class.getResource("/cards/backCard.jpg")));
		btnNewButton.setBounds(10, 348, 53, 81);
		contentPane.add(btnNewButton);
		//label for the kingdoms
		JLabel lblNewLabel_1 = new JLabel("knwsos path");
		lblNewLabel_1.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/knossos.jpg")));
		lblNewLabel_1.setBounds(183, 291, 53, 46);
		contentPane.add(lblNewLabel_1);
		//label for the kingdoms
		JLabel lblKnwsosPath = new JLabel("knwsos path");
		lblKnwsosPath.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/knossos2.jpg")));
		lblKnwsosPath.setBounds(240, 291, 53, 46);
		contentPane.add(lblKnwsosPath);
		//label for points in path
		JLabel label_4 = new JLabel("5 points");
		label_4.setForeground(Color.BLACK);
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(346, 266, 47, 14);
		contentPane.add(label_4);
		//label for points in path
		JLabel label_7 = new JLabel("50 points");
		label_7.setForeground(Color.BLACK);
		label_7.setBackground(Color.WHITE);
		label_7.setBounds(615, 266, 46, 14);
		contentPane.add(label_7);
		//label for points in path
		JLabel lblPointsCheck = new JLabel("30 points ");
		lblPointsCheck.setVerticalAlignment(SwingConstants.TOP);
		lblPointsCheck.setForeground(Color.BLACK);
		lblPointsCheck.setBackground(Color.WHITE);
		lblPointsCheck.setBounds(505, 266, 53, 14);
		contentPane.add(lblPointsCheck);
		//label for points in path
		JLabel label_6 = new JLabel("35 points");
		label_6.setForeground(Color.BLACK);
		label_6.setBackground(Color.WHITE);
		label_6.setBounds(559, 266, 46, 14);
		contentPane.add(label_6);
		//label for points in path
		JLabel lblPoints_1 = new JLabel("15 points");
		lblPoints_1.setForeground(Color.BLACK);
		lblPoints_1.setBackground(Color.WHITE);
		lblPoints_1.setBounds(452, 266, 46, 14);
		contentPane.add(lblPoints_1);
		//label for points in path
		JLabel label_5 = new JLabel("10 points");
		label_5.setForeground(Color.BLACK);
		label_5.setBackground(Color.WHITE);
		label_5.setBounds(399, 266, 46, 14);
		contentPane.add(label_5);
		//label for points in path
		JLabel label_2 = new JLabel("20 points");
		label_2.setForeground(Color.BLACK);
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(183, 266, 46, 14);
		contentPane.add(label_2);
		//label for points in path
		JLabel label_3 = new JLabel("-10 points");
		label_3.setForeground(Color.BLACK);
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(293, 266, 53, 14);
		contentPane.add(label_3);
		//label for the kingdoms
		JLabel lblKnwsosPath_1 = new JLabel("knwsos path");
		lblKnwsosPath_1.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/knossos.jpg")));
		lblKnwsosPath_1.setBounds(293, 291, 53, 46);
		contentPane.add(lblKnwsosPath_1);
		//label for the kingdoms
		JLabel lblKnwsosPath_2 = new JLabel("knwsos path");
		lblKnwsosPath_2.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/knossos2.jpg")));
		lblKnwsosPath_2.setBounds(346, 291, 53, 46);
		contentPane.add(lblKnwsosPath_2);
		//label for the kingdoms
		JLabel lblKnwsosPath_3 = new JLabel("knwsos path");
		lblKnwsosPath_3.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/knossos.jpg")));
		lblKnwsosPath_3.setBounds(399, 291, 53, 46);
		contentPane.add(lblKnwsosPath_3);
		//label for the kingdoms
		JLabel lblKnwsosPath_4 = new JLabel("knwsos path");
		lblKnwsosPath_4.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/knossos2.jpg")));
		lblKnwsosPath_4.setBounds(452, 291, 53, 46);
		contentPane.add(lblKnwsosPath_4);
		//label for the kingdoms
		JLabel lblKnwsosPath_5 = new JLabel("knwsos path");
		lblKnwsosPath_5.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/knossos.jpg")));
		lblKnwsosPath_5.setBounds(505, 291, 53, 46);
		contentPane.add(lblKnwsosPath_5);
		//label for the kingdoms
		JLabel lblKnwsosPath_6 = new JLabel("knwsos path");
		lblKnwsosPath_6.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/knossos2.jpg")));
		lblKnwsosPath_6.setBounds(559, 291, 47, 46);
		contentPane.add(lblKnwsosPath_6);
		//label for the kingdoms
		JLabel lblKnwsosPathFinal = new JLabel("knwsos path final");
		lblKnwsosPathFinal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"To minoiko anaktoro einai o kyrios episkepsimos xoros tis Knosoy (i Knossoy), simantikis polis kata tin arxaiotita, me synexi zoi apo ta neolithika xronia eos ton 5o ai." +
			"\nEinai xtismeno sto lofo tis Kefalas, me eykoli prosbasi sti thalassa alla kai sto esoteriko tis Kritis. Kata tin paradosi, ypirxe i edra toy sofoy basilia Minoa. Synarpastikoi mythoi,"+
						"\n toy Labyrinthoy me to Minotayro kai toy Daidaloy me ton Ikaro, syndeontai me to anaktoro tis Knossoy.");
			}
		});
		lblKnwsosPathFinal.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/knossosPalace.jpg")));
		lblKnwsosPathFinal.setBounds(615, 288, 69, 53);
		contentPane.add(lblKnwsosPathFinal);
		//label for the kingdoms
		JLabel lblMaliaPath = new JLabel("malia path");
		lblMaliaPath.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/malia.jpg")));
		lblMaliaPath.setBounds(183, 348, 53, 43);
		contentPane.add(lblMaliaPath);
		//label for the kingdoms
		JLabel lblMaliaPath_1 = new JLabel("malia path");
		lblMaliaPath_1.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/malia2.jpg")));
		lblMaliaPath_1.setBounds(240, 348, 53, 43);
		contentPane.add(lblMaliaPath_1);
		//label for the kingdoms
		JLabel lblMaliaPath_2 = new JLabel("malia path");
		lblMaliaPath_2.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/malia.jpg")));
		lblMaliaPath_2.setBounds(293, 348, 53, 43);
		contentPane.add(lblMaliaPath_2);
		//label for the kingdoms
		JLabel lblMaliaPath_3 = new JLabel("malia path");
		lblMaliaPath_3.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/malia2.jpg")));
		lblMaliaPath_3.setBounds(346, 348, 53, 43);
		contentPane.add(lblMaliaPath_3);
		//label for the kingdoms
		JLabel lblMaliaPath_4 = new JLabel("malia path");
		lblMaliaPath_4.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/malia.jpg")));
		lblMaliaPath_4.setBounds(399, 348, 53, 43);
		contentPane.add(lblMaliaPath_4);
		//label for the kingdoms
		JLabel lblMaliaPath_7 = new JLabel("malia path");
		lblMaliaPath_7.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/malia2.jpg")));
		lblMaliaPath_7.setBounds(558, 348, 53, 43);
		contentPane.add(lblMaliaPath_7);
		//label for the kingdoms
		JLabel lblMaliaPath_6 = new JLabel("malia path");
		lblMaliaPath_6.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/malia.jpg")));
		lblMaliaPath_6.setBounds(505, 348, 53, 43);
		contentPane.add(lblMaliaPath_6);
		//label for the kingdoms
		JLabel lblMaliaPath_5 = new JLabel("malia path");
		lblMaliaPath_5.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/malia2.jpg")));
		lblMaliaPath_5.setBounds(452, 348, 53, 43);
		contentPane.add(lblMaliaPath_5);
		//label for the kingdoms
		JLabel lblMaliaPathKingdom = new JLabel("malia path kingdom");
		lblMaliaPathKingdom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {JOptionPane.showMessageDialog(null," Anatolika apo ta simerina Malia brisketai to minoiko anaktoro ton Malion. Einai to trito se megethos anaktoro tis minoikis Kritis kai einai xtismeno se mia topothesia pronomiaki," 
					+"\nkonta sti thalassa kai pano sto dromo poy syndeei tin anatoliki me tin kentriki Kriti. To anaktoro ton Malion kata ti mythologia xrisimeye" 
					+"\nsan katoikia toy Sarpidona, aderfoy toy Minoa, kai protoxtizetai to 1900 p.X. O proYparxon isxyros oikismos, apo ton opoio sozontai synoikies gyro apo to anaktoro, metatrepetai etsi se anaktoriko kentro-poli.	");
		}
			}
		);
		lblMaliaPathKingdom.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/maliaPalace.jpg")));
		lblMaliaPathKingdom.setBounds(615, 342, 69, 53);
		contentPane.add(lblMaliaPathKingdom);
		//label for the kingdoms
		JLabel lblFaistosPath = new JLabel("faistos path");
		lblFaistosPath.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/phaistos.jpg")));
		lblFaistosPath.setBounds(183, 403, 53, 43);
		contentPane.add(lblFaistosPath);
		//label for the kingdoms
		JLabel lblFaistosPath_1 = new JLabel("faistos path");
		lblFaistosPath_1.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/phaistos2.jpg")));
		lblFaistosPath_1.setBounds(240, 403, 53, 43);
		contentPane.add(lblFaistosPath_1);
		//label for the kingdoms
		JLabel lblFaistosPath_2 = new JLabel("faistos path");
		lblFaistosPath_2.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/phaistos.jpg")));
		lblFaistosPath_2.setBounds(293, 403, 53, 43);
		contentPane.add(lblFaistosPath_2);
		//label for the kingdoms
		JLabel lblFaistosPath_3 = new JLabel("faistos path");
		lblFaistosPath_3.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/phaistos2.jpg")));
		lblFaistosPath_3.setBounds(346, 403, 53, 43);
		contentPane.add(lblFaistosPath_3);
		//label for the kingdoms
		JLabel lblFaistosPath_4 = new JLabel("faistos path");
		lblFaistosPath_4.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/phaistos.jpg")));
		lblFaistosPath_4.setBounds(399, 403, 53, 43);
		contentPane.add(lblFaistosPath_4);
		//label for the kingdoms
		JLabel lblFaistosPath_5 = new JLabel("faistos path");
		lblFaistosPath_5.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/phaistos2.jpg")));
		lblFaistosPath_5.setBounds(452, 403, 47, 43);
		contentPane.add(lblFaistosPath_5);
		//label for the kingdoms
		JLabel lblFaistosPath_6 = new JLabel("faistos path");
		lblFaistosPath_6.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/phaistos.jpg")));
		lblFaistosPath_6.setBounds(505, 403, 53, 43);
		contentPane.add(lblFaistosPath_6);
		//label for the kingdoms
		JLabel lblFaistosPath_7 = new JLabel("faistos path");
		lblFaistosPath_7.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/phaistos2.jpg")));
		lblFaistosPath_7.setBounds(568, 403, 53, 43);
		contentPane.add(lblFaistosPath_7);
		//label for the kingdoms
		JLabel lblFaistosKingdom = new JLabel("faistos kingdom");
		lblFaistosKingdom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null," To Minoiko Anaktoro tis Faistoy brisketai stin notio-kentriki Kriti, stin pediada tis Mesaras, 55 xiliometra notia apo to Irakleio kai se mikri apostasi apo ton arxaiologiko xoro stin Agia Triada," 
			+"\nton arxaiologiko xoro sti Gortyna kai ta Matala. To minoiko anaktoro tis Faistoy antistoixei se akmaia poli poy, oxi tyxaia, anaptyxthike stin efori pediada tis Mesaras kata toys proIstorikoys xronoys, diladi apo to 6.000 p.X."+
						" \nperipoy mexri kai ton 1o p.X. aiona, opos epibebaionoyn ta arxaiologika eyrimata.	");
			}
		});
		lblFaistosKingdom.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/phaistosPalace.jpg")));
		lblFaistosKingdom.setBounds(615, 398, 69, 53);
		contentPane.add(lblFaistosKingdom);
		//label for the kingdoms
		JLabel lblZagriKingdom = new JLabel("zagri kingdom");
		lblZagriKingdom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null," To anaktoro tis Zakroy einai to tetarto se megethostis Minoikis Kritis. Briskotan se simantiko stratigiko simeio, se asfalismeno kolpisko, kai itan kentro emporikon antallagon me tis xores tis Anatolis," 
			+"\nopos fainetai apo ta eyrimata (xayliodontes elefanta, fagentiani, xalkos klp).  To anaktoro apotelese to kentro dioikisis, thriskeias kai emporioy." 
						+"\nTo peristoixize i poli. Sto xoro den egine nea oikodomisi, ektos apo kapoies kalliergeies. 	");
			}
		});
		lblZagriKingdom.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/zakrosPalace.jpg")));
		lblZagriKingdom.setBounds(615, 455, 69, 53);
		contentPane.add(lblZagriKingdom);
		//label for the kingdoms
		JLabel lblZagriPath = new JLabel("zagri path");
		lblZagriPath.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/zakros.jpg")));
		lblZagriPath.setBounds(183, 460, 53, 43);
		contentPane.add(lblZagriPath);
		//label for the kingdoms
		JLabel lblZagriPath_1 = new JLabel("zagri path");
		lblZagriPath_1.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/zakros2.jpg")));
		lblZagriPath_1.setBounds(240, 460, 53, 43);
		contentPane.add(lblZagriPath_1);
		//label for the kingdoms
		JLabel lblZagriPath_2 = new JLabel("zagri path");
		lblZagriPath_2.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/zakros.jpg")));
		lblZagriPath_2.setBounds(293, 460, 53, 43);
		contentPane.add(lblZagriPath_2);
		//label for the kingdoms
		JLabel lblZagriPath_3 = new JLabel("zagri path");
		lblZagriPath_3.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/zakros2.jpg")));
		lblZagriPath_3.setBounds(346, 460, 53, 43);
		contentPane.add(lblZagriPath_3);
		//label for the kingdoms
		JLabel lblZagriPath_4 = new JLabel("zagri path");
		lblZagriPath_4.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/zakros.jpg")));
		lblZagriPath_4.setBounds(399, 460, 53, 43);
		contentPane.add(lblZagriPath_4);
		//label for the kingdoms
		JLabel lblZagriPath_5 = new JLabel("zagri path");
		lblZagriPath_5.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/zakros2.jpg")));
		lblZagriPath_5.setBounds(452, 460, 53, 43);
		contentPane.add(lblZagriPath_5);
		//label for the kingdoms
		JLabel lblZagriPath_6 = new JLabel("zagri path");
		lblZagriPath_6.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/zakros.jpg")));
		lblZagriPath_6.setBounds(505, 460, 53, 43);
		contentPane.add(lblZagriPath_6);
		//label for the kingdoms
		JLabel lblZagriPath_7 = new JLabel("zagri path");
		lblZagriPath_7.setIcon(new ImageIcon(GraphicsUi.class.getResource("/paths/zakros2.jpg")));
		lblZagriPath_7.setBounds(558, 460, 53, 43);
		contentPane.add(lblZagriPath_7);
		
		JLabel lblPoints = new JLabel("-15 points");
		lblPoints.setForeground(Color.BLACK);
		lblPoints.setBackground(Color.WHITE);
		lblPoints.setBounds(240, 266, 53, 14);
		contentPane.add(lblPoints);
		//label for backround image
		JLabel lblNewLabel = new JLabel("backround");
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(GraphicsUi.class.getResource("/pionia/background.jpg")));
		lblNewLabel.setBounds(0, 219, 784, 301);
		contentPane.add(lblNewLabel);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(Color.RED));
		layeredPane.setForeground(Color.WHITE);
		layeredPane.setBackground(Color.WHITE);
		layeredPane.setBounds(0, 0, 784, 217);
		contentPane.add(layeredPane);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_8 = new JButton("karta2 p1");
		btnKartaP_8.setIcon(null);
		btnKartaP_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest2==1){
					Point pt=lblNewLabel_5.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblNewLabel_5.setLocation(x+55,y);}
					if(pathtest2==3){
						Point pt=lblPPioni.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni.setLocation(x+55,y);}
					if(pathtest2==2){
						Point pt=lblPPioni_1.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_1.setLocation(x+55,y);}
					if(pathtest2==4){
						Point pt=lblPlayerHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPlayerHero.setLocation(x+55,y);}
			}
		});
		btnKartaP_8.setBounds(78, 11, 68, 100);
		layeredPane.add(btnKartaP_8);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_9 = new JButton("karta3 p1");
		btnKartaP_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest3==1){
					Point pt=lblNewLabel_5.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblNewLabel_5.setLocation(x+55,y);}
					if(pathtest3==3){
						Point pt=lblPPioni.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni.setLocation(x+55,y);}
					if(pathtest3==2){
						Point pt=lblPPioni_1.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_1.setLocation(x+55,y);}
					if(pathtest3==4){
						Point pt=lblPlayerHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPlayerHero.setLocation(x+55,y);}
			}
		});
		btnKartaP_9.setIcon(null);
		btnKartaP_9.setBounds(156, 11, 68, 100);
		layeredPane.add(btnKartaP_9);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_10 = new JButton("karta4 p1");
		btnKartaP_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest4==1){
					Point pt=lblNewLabel_5.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblNewLabel_5.setLocation(x+55,y);}
					if(pathtest4==3){
						Point pt=lblPPioni.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni.setLocation(x+55,y);}
					if(pathtest4==2){
						Point pt=lblPPioni_1.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_1.setLocation(x+55,y);}
					if(pathtest4==4){
						Point pt=lblPlayerHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPlayerHero.setLocation(x+55,y);}
			}
		});
		btnKartaP_10.setIcon(null);
		btnKartaP_10.setBounds(234, 11, 68, 100);
		layeredPane.add(btnKartaP_10);
		//button for the cards and actions when the card is played
		final JButton btnKartP = new JButton("kart5 p1");
		btnKartP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest5==1){
					Point pt=lblNewLabel_5.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblNewLabel_5.setLocation(x+55,y);}
					if(pathtest5==3){
						Point pt=lblPPioni.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni.setLocation(x+55,y);}
					if(pathtest5==2){
						Point pt=lblPPioni_1.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_1.setLocation(x+55,y);}
					if(pathtest5==4){
						Point pt=lblPlayerHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPlayerHero.setLocation(x+55,y);}
			}
		});
		btnKartP.setIcon(null);
		btnKartP.setBounds(312, 11, 68, 100);
		layeredPane.add(btnKartP);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_11 = new JButton("karta6 p1");
		btnKartaP_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest6==1){
					Point pt=lblNewLabel_5.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblNewLabel_5.setLocation(x+55,y);}
					if(pathtest6==3){
						Point pt=lblPPioni.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni.setLocation(x+55,y);}
					if(pathtest6==2){
						Point pt=lblPPioni_1.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_1.setLocation(x+55,y);}
					if(pathtest6==4){
						Point pt=lblPlayerHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPlayerHero.setLocation(x+55,y);}
			}
		});
		btnKartaP_11.setIcon(null);
		btnKartaP_11.setBounds(390, 11, 68, 100);
		layeredPane.add(btnKartaP_11);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_12 = new JButton("karta7 p1");
		btnKartaP_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest7==1){
					Point pt=lblNewLabel_5.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblNewLabel_5.setLocation(x+55,y);}
					if(pathtest7==3){
						Point pt=lblPPioni.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni.setLocation(x+55,y);}
					if(pathtest7==2){
						Point pt=lblPPioni_1.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_1.setLocation(x+55,y);}
					if(pathtest7==4){
						Point pt=lblPlayerHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPlayerHero.setLocation(x+55,y);}
			}
		});
		btnKartaP_12.setIcon(null);
		btnKartaP_12.setBounds(468, 11, 68, 100);
		layeredPane.add(btnKartaP_12);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_13 = new JButton("karta8 p1");
		btnKartaP_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest8==1){
					Point pt=lblNewLabel_5.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblNewLabel_5.setLocation(x+55,y);}
					if(pathtest8==3){
						Point pt=lblPPioni.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni.setLocation(x+55,y);}
					if(pathtest8==2){
						Point pt=lblPPioni_1.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_1.setLocation(x+55,y);}
					if(pathtest8==4){
						Point pt=lblPlayerHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPlayerHero.setLocation(x+55,y);}
			}
		});
		btnKartaP_13.setIcon(null);
		btnKartaP_13.setBounds(546, 11, 68, 100);
		layeredPane.add(btnKartaP_13);
		//button for the cards and actions when the card is played
		JButton btnLastcardKnwsos = new JButton("lastCard knwsos");
		btnLastcardKnwsos.setIcon(new ImageIcon(GraphicsUi.class.getResource("/cards/Knossos6.jpg")));
		btnLastcardKnwsos.setBounds(219, 122, 57, 84);
		layeredPane.add(btnLastcardKnwsos);
		//button for the final card playing
		JButton btnLastcard = new JButton("lastCard ");
		btnLastcard.setIcon(new ImageIcon(GraphicsUi.class.getResource("/cards/knossos9.jpg")));
		btnLastcard.setBounds(340, 122, 57, 84);
		layeredPane.add(btnLastcard);
		//button for the final card playing
		JButton btnLastcard_1 = new JButton("lastCard");
		btnLastcard_1.setIcon(new ImageIcon(GraphicsUi.class.getResource("/cards/malia4.jpg")));
		btnLastcard_1.setBounds(450, 122, 57, 84);
		layeredPane.add(btnLastcard_1);
		//button for the final card playing
		JButton btnLastcard_2 = new JButton("lastCard");
		btnLastcard_2.setIcon(new ImageIcon(GraphicsUi.class.getResource("/cards/phaistos5.jpg")));
		btnLastcard_2.setBounds(538, 122, 57, 84);
		layeredPane.add(btnLastcard_2);
		Controller points=new Controller();
		String p1="player 1 "+points.PlayerScore();;
		final JLabel lblScoreP = new JLabel(p1);
		lblScoreP.setVisible(false);
		lblScoreP.setBounds(651, 27, 68, 25);
		layeredPane.add(lblScoreP);
		//button for the drowings it creates a new window
		JButton btnNewButton_2 = new JButton("toixografeies ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ToixografiesNewWindow nw= new ToixografiesNewWindow();
				nw.toixografiesnew();
				
			}
		});
		
		btnNewButton_2.setBounds(631, 63, 122, 41);
		layeredPane.add(btnNewButton_2);
		//label for statues takes info from controller
		String agalmatakia="agalmatakia "+ info.PlayerStat();
		final JLabel lblAgalmatakia = new JLabel("agalma 0");
		lblAgalmatakia.setVisible(false);
		lblAgalmatakia.setBounds(631, 157, 78, 31);
		layeredPane.add(lblAgalmatakia);
		//icon for the statues
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"Os i thea me ta fidia onomazetai o typos agalmatidioy poy brethike se anaskafes stoys Minoikoys arxaiologikoys topoys poy paroysiazei gynaika na krataei fidia."
						+ "\nTa agalmatida xronologoyntai ston 16o aiona p.X.. Liges plirofories exoyme gia tin ermineia ton agalmatidion. O Ebans syndeei tin thea ton ofeon me tin Aigyptiaki thea Oyatzet. Einai propompos tis kritikis Reas kai paroysiazei megali omoiotita me tin frygiki Kybeli kai tin efesia Artemida.");
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(GraphicsUi.class.getResource("/findings/snakes.jpg")));
		lblNewLabel_3.setBounds(738, 140, 46, 49);
		layeredPane.add(lblNewLabel_3);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_14 = new JButton("karta1 p1");
		btnKartaP_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest1==1){
				Point pt=lblNewLabel_5.getLocation();
				int x=pt.x;
				int y=pt.y;
				lblNewLabel_5.setLocation(x+55,y);}
				if(pathtest1==3){
					Point pt=lblPPioni.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblPPioni.setLocation(x+55,y);}
				if(pathtest1==2){
					Point pt=lblPPioni_1.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblPPioni_1.setLocation(x+55,y);}
				if(pathtest1==4){
					Point pt=lblPlayerHero.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblPlayerHero.setLocation(x+55,y);}
				
				
				}
		});
		btnKartaP_14.setIcon(null);
		btnKartaP_14.setBounds(0, 11, 68, 100);
		layeredPane.add(btnKartaP_14);
		//exit button exits the game
		Button button = new Button("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setBackground(Color.BLACK);
		button.setBounds(714, 0, 70, 22);
		layeredPane.add(button);
		//button for the turn of player 1
		final JButton btnPlayer = new JButton("Player 1");
		btnPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_5.setVisible(true);
				lblPPioni.setVisible(true);
				lblPPioni_1.setVisible(true);
				lblPlayerHero.setVisible(true);
				lblPPioni_4.setVisible(false);
				lblPHero.setVisible(false);
				lblPPioni_3.setVisible(false);
				lblPPioni_2.setVisible(false);
				
				
				
				
			}
		});
		btnPlayer.setBounds(0, 183, 89, 23);
		layeredPane.add(btnPlayer);
		//label for findings
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"O Diskos tis Faistoy einai ena arxaiologiko eyrima apo ti Minoiki poli tis Faistoy sti notia Kriti kai xronologeitai pithanos ston 17o aiona p.X.. "+
			"\nApotelei ena apo ta gnostotera mystiria tis arxaiologias, afoy o skopos tis kataskeyis toy kai to noima ton oson anagrafontai se ayton paramenoyn agnosta."+ 
						"\nO diskos anakalyfthike stis 3 Ioylioy 1908 apo ton Italo arxaiologo Loyitzi Pernie (Luigi Pernier) kai fylassetai simera sto Arxaiologiko Moyseio Irakleioy.");
				
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(GraphicsUi.class.getResource("/findings/diskos.jpg")));
		lblNewLabel_2.setBounds(181, 179, 24, 30);
		layeredPane.add(lblNewLabel_2);
		//label for findings
		JLabel label = new JLabel("New label");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"To xryso kosmima ton melisson poy filoxeneitai sto Arxaiologiko Moyseio Irakleioy, einai diasimo arxaiologiko eyrima apo ton Xrysolakko, ton tafiko peribolo tis nekropolis ton Malion.	");
			}
		});
		label.setIcon(new ImageIcon(GraphicsUi.class.getResource("/findings/kosmima.jpg")));
		label.setBounds(306, 181, 24, 25);
		layeredPane.add(label);
		//label for findings
		JLabel label_1 = new JLabel("New label");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"To «Daxtylidi toy Minoa», ena apo ta megalytera kai spaniotera xrysa sfragidika ston kosmo," +
			"\ntheoreitai apo ta kalytera deigmata tis kritomykinaIkis sfragidikis. Ferei syntheti thriskeytiki parastasi, poy apeikonizei morfes oi opoies entassontai stin kritomykinaIki thematologia, dentrolatria me kathisti thea, oyrano, gi kai thalassa, me iero ploio poy exei morfi ippokampoy.	");
			}
		});
		label_1.setIcon(new ImageIcon(GraphicsUi.class.getResource("/findings/ring.jpg")));
		label_1.setBounds(417, 176, 24, 30);
		layeredPane.add(label_1);
		//label for findings
		JLabel label_8 = new JLabel("New label");
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"To aggeio brethike sto thisayrofylakio toy anaktoroy tis Zakroy mazi me alla monadika sto eidos toys teletoyrgika skeyi tis neoanaktorikis epoxis kai apotelei xaraktiristiko paradeigma tis efeyretikotitas kai kalaisthisias ton Minoiton texniton.	");
			}
		});
		label_8.setIcon(new ImageIcon(GraphicsUi.class.getResource("/findings/ruto.jpg")));
		label_8.setBounds(512, 179, 16, 30);
		layeredPane.add(label_8);
		btnPlayer.setVisible(false);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		layeredPane_1.setBounds(785, 540, -780, 196);
		contentPane.add(layeredPane_1);
		//button for the cards and actions when the card is played
		final JButton btnKartaP = new JButton("karta1 p2");
		btnKartaP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest9==1){
					Point pt=lblPPioni_2.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblPPioni_2.setLocation(x+55,y);}
					if(pathtest9==3){
						Point pt=lblPPioni_3.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_3.setLocation(x+55,y);}
					if(pathtest9==2){
						Point pt=lblPHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPHero.setLocation(x+55,y);}
					if(pathtest9==4){
						Point pt=lblPPioni_4.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_4.setLocation(x+55,y);}
			}
		});
		btnKartaP.setIcon(null);
		btnKartaP.setBounds(10, 540, 68, 100);
		contentPane.add(btnKartaP);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_1 = new JButton("karta2 p2");
		btnKartaP_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest10==1){
					Point pt=lblPPioni_2.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblPPioni_2.setLocation(x+55,y);}
					if(pathtest10==3){
						Point pt=lblPPioni_3.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_3.setLocation(x+55,y);}
					if(pathtest10==2){
						Point pt=lblPHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPHero.setLocation(x+55,y);}
					if(pathtest10==4){
						Point pt=lblPPioni_4.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_4.setLocation(x+55,y);}
			}
		});
		btnKartaP_1.setIcon(null);
		btnKartaP_1.setBounds(88, 540, 68, 100);
		contentPane.add(btnKartaP_1);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_2 = new JButton("karta3 p2");
		btnKartaP_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest11==1){
					Point pt=lblPPioni_2.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblPPioni_2.setLocation(x+55,y);}
					if(pathtest11==3){
						Point pt=lblPPioni_3.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_3.setLocation(x+55,y);}
					if(pathtest11==2){
						Point pt=lblPHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPHero.setLocation(x+55,y);}
					if(pathtest11==4){
						Point pt=lblPPioni_4.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_4.setLocation(x+55,y);}
			}
		});
		btnKartaP_2.setIcon(null);
		btnKartaP_2.setBounds(168, 540, 68, 100);
		contentPane.add(btnKartaP_2);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_3 = new JButton("karta4 p2");
		btnKartaP_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest12==1){
					Point pt=lblPPioni_2.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblPPioni_2.setLocation(x+55,y);}
					if(pathtest12==3){
						Point pt=lblPPioni_3.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_3.setLocation(x+55,y);}
					if(pathtest12==2){
						Point pt=lblPHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPHero.setLocation(x+55,y);}
					if(pathtest12==4){
						Point pt=lblPPioni_4.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_4.setLocation(x+55,y);}
			}
		});
		btnKartaP_3.setIcon(null);
		btnKartaP_3.setBounds(250, 540, 68, 100);
		contentPane.add(btnKartaP_3);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_4 = new JButton("karta5 p2");
		btnKartaP_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest13==1){
					Point pt=lblPPioni_2.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblPPioni_2.setLocation(x+55,y);}
					if(pathtest13==3){
						Point pt=lblPPioni_3.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_3.setLocation(x+55,y);}
					if(pathtest13==2){
						Point pt=lblPHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPHero.setLocation(x+55,y);}
					if(pathtest13==4){
						Point pt=lblPPioni_4.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_4.setLocation(x+55,y);}
			}
		});
		btnKartaP_4.setIcon(null);
		btnKartaP_4.setBounds(328, 540, 68, 100);
		contentPane.add(btnKartaP_4);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_5 = new JButton("karta6 p2");
		btnKartaP_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest14==1){
					Point pt=lblPPioni_2.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblPPioni_2.setLocation(x+55,y);}
					if(pathtest14==3){
						Point pt=lblPPioni_3.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_3.setLocation(x+55,y);}
					if(pathtest14==2){
						Point pt=lblPHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPHero.setLocation(x+55,y);}
					if(pathtest14==4){
						Point pt=lblPPioni_4.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_4.setLocation(x+55,y);}
			}
		});
		btnKartaP_5.setIcon(null);
		btnKartaP_5.setBounds(406, 540, 68, 100);
		contentPane.add(btnKartaP_5);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_6 = new JButton("karta7 p2");
		btnKartaP_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest15==1){
					Point pt=lblPPioni_2.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblPPioni_2.setLocation(x+55,y);}
					if(pathtest15==3){
						Point pt=lblPPioni_3.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_3.setLocation(x+55,y);}
					if(pathtest15==2){
						Point pt=lblPHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPHero.setLocation(x+55,y);}
					if(pathtest15==4){
						Point pt=lblPPioni_4.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_4.setLocation(x+55,y);}
			}
		});
		btnKartaP_6.setIcon(null);
		btnKartaP_6.setBounds(490, 540, 68, 100);
		contentPane.add(btnKartaP_6);
		//button for the cards and actions when the card is played
		final JButton btnKartaP_7 = new JButton("karta8 p2");
		btnKartaP_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pathtest16==1){
					Point pt=lblPPioni_2.getLocation();
					int x=pt.x;
					int y=pt.y;
					lblPPioni_2.setLocation(x+55,y);}
					if(pathtest16==3){
						Point pt=lblPPioni_3.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_3.setLocation(x+55,y);}
					if(pathtest16==2){
						Point pt=lblPHero.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPHero.setLocation(x+55,y);}
					if(pathtest16==4){
						Point pt=lblPPioni_4.getLocation();
						int x=pt.x;
						int y=pt.y;
						lblPPioni_4.setLocation(x+55,y);}
			}
		});
		btnKartaP_7.setIcon(null);
		btnKartaP_7.setBounds(580, 540, 68, 100);
		contentPane.add(btnKartaP_7);
		//Button for last cards playing
		JButton button_21 = new JButton("New button");
		button_21.setIcon(new ImageIcon(GraphicsUi.class.getResource("/cards/phaistos10.jpg")));
		button_21.setBounds(65, 651, 57, 84);
		contentPane.add(button_21);
		//Button for last cards playing
		JButton button_22 = new JButton("New button");
		button_22.setIcon(new ImageIcon(GraphicsUi.class.getResource("/cards/zakros1.jpg")));
		button_22.setBounds(150, 652, 57, 84);
		contentPane.add(button_22);
		//Button for last cards playing
		JButton button_23 = new JButton("New button");
		button_23.setIcon(new ImageIcon(GraphicsUi.class.getResource("/cards/knossos3.jpg")));
		button_23.setBounds(224, 652, 57, 84);
		contentPane.add(button_23);
		//Button for last cards playing
		JButton button_24 = new JButton("New button");
		button_24.setIcon(new ImageIcon(GraphicsUi.class.getResource("/cards/malia5.jpg")));
		button_24.setBounds(293, 652, 53, 84);
		contentPane.add(button_24);
		//label for the points of player 2
		String p2="player 2 "+points.PlayerScore();
		final JLabel lblScore = new JLabel(p2);
		lblScore.setVisible(false);
		lblScore.setBounds(682, 555, 63, 33);
		contentPane.add(lblScore);
		//label for drawings opens a new window
		JButton button_25 = new JButton("toixografeies ");
		button_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ToixografiesNewWindow nw= new ToixografiesNewWindow();
				nw.toixografiesnew();
			}
		});
		button_25.setBounds(653, 599, 122, 41);
		contentPane.add(button_25);
		
		final JLabel lblAgalma = new JLabel("agalma 0");
		lblAgalma.setVisible(false);
		lblAgalma.setBounds(604, 681, 57, 25);
		contentPane.add(lblAgalma);
		//label for findings
		JLabel label_9 = new JLabel("New label");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"Os i thea me ta fidia onomazetai o typos agalmatidioy poy brethike se anaskafes stoys Minoikoys arxaiologikoys topoys poy paroysiazei gynaika na krataei fidia."
						+ "\nTa agalmatida xronologoyntai ston 16o aiona p.X.. Liges plirofories exoyme gia tin ermineia ton agalmatidion. O Ebans syndeei tin thea ton ofeon me tin Aigyptiaki thea Oyatzet. Einai propompos tis kritikis Reas kai paroysiazei megali omoiotita me tin frygiki Kybeli kai tin efesia Artemida.");
			}
		});
		label_9.setIcon(new ImageIcon(GraphicsUi.class.getResource("/findings/snakes.jpg")));
		label_9.setBounds(699, 669, 46, 49);
		contentPane.add(label_9);
		// button for the player 2
		final JButton btnPlayer_1 = new JButton("Player 2");
		btnPlayer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_5.setVisible(false);
				lblPPioni.setVisible(false);
				lblPPioni_1.setVisible(false);
				lblPlayerHero.setVisible(false);
				lblPPioni_4.setVisible(true);
				lblPHero.setVisible(true);
				lblPPioni_3.setVisible(true);
				lblPPioni_2.setVisible(true);
				
			}
		});
		btnPlayer_1.setVisible(false);
		btnPlayer_1.setBounds(682, 521, 89, 23);
		contentPane.add(btnPlayer_1);
		//button for play the game it crates the cards set the pawns 
		JButton btnNewButton_1 = new JButton("Play");
		btnNewButton_1.setBounds(615, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		//label for findings
		JLabel label_10 = new JLabel("New label");
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"O Diskos tis Faistoy einai ena arxaiologiko eyrima apo ti Minoiki poli tis Faistoy sti notia Kriti kai xronologeitai pithanos ston 17o aiona p.X.. "+
			"\nApotelei ena apo ta gnostotera mystiria tis arxaiologias, afoy o skopos tis kataskeyis toy kai to noima ton oson anagrafontai se ayton paramenoyn agnosta."+ 
						"\nO diskos anakalyfthike stis 3 Ioylioy 1908 apo ton Italo arxaiologo Loyitzi Pernie (Luigi Pernier) kai fylassetai simera sto Arxaiologiko Moyseio Irakleioy.");
				
			}
		});
		label_10.setIcon(new ImageIcon(GraphicsUi.class.getResource("/findings/diskos.jpg")));
		label_10.setBounds(75, 731, 24, 30);
		contentPane.add(label_10);
		//label for findings
		JLabel label_11 = new JLabel("New label");
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"To xryso kosmima ton melisson poy filoxeneitai sto Arxaiologiko Moyseio Irakleioy, einai diasimo arxaiologiko eyrima apo ton Xrysolakko, ton tafiko peribolo tis nekropolis ton Malion.	");
			}
		});
		label_11.setIcon(new ImageIcon(GraphicsUi.class.getResource("/findings/kosmima.jpg")));
		label_11.setBounds(170, 731, 24, 30);
		contentPane.add(label_11);
		//label for findings
		JLabel label_12 = new JLabel("New label");
		label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"To «Daxtylidi toy Minoa», ena apo ta megalytera kai spaniotera xrysa sfragidika ston kosmo," +
						"\ntheoreitai apo ta kalytera deigmata tis kritomykinaIkis sfragidikis. Ferei syntheti thriskeytiki parastasi, poy apeikonizei morfes oi opoies entassontai stin kritomykinaIki thematologia, dentrolatria me kathisti thea, oyrano, gi kai thalassa, me iero ploio poy exei morfi ippokampoy.	");
						}
		});
		label_12.setIcon(new ImageIcon(GraphicsUi.class.getResource("/findings/ring.jpg")));
		label_12.setBounds(234, 734, 24, 25);
		contentPane.add(label_12);
		//label for findings
		JLabel label_13 = new JLabel("New label");
		label_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"To aggeio brethike sto thisayrofylakio toy anaktoroy tis Zakroy mazi me alla monadika sto eidos toys teletoyrgika skeyi tis neoanaktorikis epoxis kai apotelei xaraktiristiko paradeigma tis efeyretikotitas kai kalaisthisias ton Minoiton texniton.	");
			}
		});
		label_13.setIcon(new ImageIcon(GraphicsUi.class.getResource("/findings/ruto.jpg")));
		label_13.setBounds(303, 731, 15, 30);
		contentPane.add(label_13);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String []images=info.setallcards();
				int rant1=info.hand();
				int rant2=info.hand();
				int rant3=info.hand();
				int rant4=info.hand();
				int rant5=info.hand();
				int rant6=info.hand();
				int rant7=info.hand();
				int rant8=info.hand();
				int rant9=info.hand();
				int rant10=info.hand();
				int rant11=info.hand();
				int rant12=info.hand();
				int rant13=info.hand();
				int rant14=info.hand();
				int rant15=info.hand();
				int rant16=info.hand();
				lblNewLabel_5.setVisible(true);
				lblPPioni.setVisible(true);
				lblPPioni_1.setVisible(true);
				lblPlayerHero.setVisible(true);
				lblPPioni_4.setVisible(false);
				lblPHero.setVisible(false);
				lblPPioni_3.setVisible(false);
				lblPPioni_2.setVisible(false);
				btnKartaP_14.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant1])));
				btnKartaP_8.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant2])));
				btnKartaP_9.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant3])));
				btnKartaP_10.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant4])));
				btnKartP.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant5])));
				btnKartaP_11.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant6])));
				btnKartaP_12.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant7])));
				btnKartaP_13.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant8])));
				btnKartaP.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant9])));
				btnKartaP_1.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant10])));
				btnKartaP_2.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant11])));
				btnKartaP_3.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant12])));
				btnKartaP_4.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant13])));
				btnKartaP_5.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant14])));
				btnKartaP_6.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant15])));
				btnKartaP_7.setIcon(new ImageIcon(GraphicsUi.class.getResource(images[rant16])));
				String keyword1 = "knossos";
				String keyword2 ="phaistos";
				String keyword3 ="malia";
				String keyword4 ="zakros";
				//test for the kingdom of the card 
				if(images[rant1].contains(keyword1)==true){
					pathtest1=1;}
				if(images[rant1].contains(keyword2)==true){
					pathtest1=2;}
				if(images[rant1].contains(keyword3)==true){
					pathtest1=3;}
				if(images[rant1].contains(keyword4)==true){
					pathtest1=4;}
				////test for the kingdom of the card 
				if(images[rant2].contains(keyword1)==true){
					pathtest2=1;}
				if(images[rant2].contains(keyword2)==true){
					pathtest2=2;}
				if(images[rant2].contains(keyword3)==true){
					pathtest2=3;}
				if(images[rant2].contains(keyword4)==true){
					pathtest2=4;}
				////test for the kingdom of the card 
				if(images[rant3].contains(keyword1)==true){
				pathtest3=1;}
			if(images[rant3].contains(keyword2)==true){
				pathtest3=2;}
			if(images[rant3].contains(keyword3)==true){
				pathtest3=3;}
			if(images[rant3].contains(keyword4)==true){
				pathtest3=4;}
				////test for the kingdom of the card 
			if(images[rant4].contains(keyword1)==true){
				pathtest4=1;}
			if(images[rant4].contains(keyword2)==true){
				pathtest4=2;}
			if(images[rant4].contains(keyword3)==true){
				pathtest4=3;}
			if(images[rant4].contains(keyword4)==true){
				pathtest4=4;}
			////test for the kingdom of the card 
			if(images[rant5].contains(keyword1)==true){
				pathtest5=1;}
			if(images[rant5].contains(keyword2)==true){
				pathtest5=2;}
			if(images[rant5].contains(keyword3)==true){
				pathtest5=3;}
			if(images[rant5].contains(keyword4)==true){
				pathtest5=4;}
			////test for the kingdom of the card 
			if(images[rant6].contains(keyword1)==true){
				pathtest6=1;}
			if(images[rant6].contains(keyword2)==true){
				pathtest6=2;}
			if(images[rant6].contains(keyword3)==true){
				pathtest6=3;}
			if(images[rant6].contains(keyword4)==true){
				pathtest6=4;}
			////test for the kingdom of the card 
			if(images[rant7].contains(keyword1)==true){
				pathtest7=1;}
			if(images[rant7].contains(keyword2)==true){
				pathtest7=2;}
			if(images[rant7].contains(keyword3)==true){
				pathtest7=3;}
			if(images[rant7].contains(keyword4)==true){
				pathtest7=4;}
			////test for the kingdom of the card 
			if(images[rant8].contains(keyword1)==true){
				pathtest8=1;}
			if(images[rant8].contains(keyword2)==true){
				pathtest8=2;}
			if(images[rant8].contains(keyword3)==true){
				pathtest8=3;}
			if(images[rant8].contains(keyword4)==true){
				pathtest8=4;}
			////test for the kingdom of the card 
			if(images[rant9].contains(keyword1)==true){
				pathtest9=1;}
			if(images[rant9].contains(keyword2)==true){
				pathtest9=2;}
			if(images[rant9].contains(keyword3)==true){
				pathtest9=3;}
			if(images[rant9].contains(keyword4)==true){
				pathtest9=4;}
			////test for the kingdom of the card 
			if(images[rant10].contains(keyword1)==true){
				pathtest10=1;}
			if(images[rant10].contains(keyword2)==true){
				pathtest10=2;}
			if(images[rant10].contains(keyword3)==true){
				pathtest10=3;}
			if(images[rant10].contains(keyword4)==true){
				pathtest10=4;}
			////test for the kingdom of the card 
			if(images[rant11].contains(keyword1)==true){
				pathtest11=1;}
			if(images[rant11].contains(keyword2)==true){
				pathtest11=2;}
			if(images[rant11].contains(keyword3)==true){
				pathtest11=3;}
			if(images[rant11].contains(keyword4)==true){
				pathtest11=4;}
			////test for the kingdom of the card 
			if(images[rant12].contains(keyword1)==true){
				pathtest12=1;}
			if(images[rant12].contains(keyword2)==true){
				pathtest12=2;}
			if(images[rant12].contains(keyword3)==true){
				pathtest12=3;}
			if(images[rant12].contains(keyword4)==true){
				pathtest12=4;}
			////test for the kingdom of the card 
			if(images[rant13].contains(keyword1)==true){
				pathtest13=1;}
			if(images[rant13].contains(keyword2)==true){
				pathtest13=2;}
			if(images[rant13].contains(keyword3)==true){
				pathtest13=3;}
			if(images[rant13].contains(keyword4)==true){
				pathtest13=4;}
			////test for the kingdom of the card 
			if(images[rant14].contains(keyword1)==true){
			pathtest14=1;}
		if(images[rant14].contains(keyword2)==true){
			pathtest14=2;}
		if(images[rant14].contains(keyword3)==true){
			pathtest14=3;}
		if(images[rant14].contains(keyword4)==true){
			pathtest14=4;}
		////test for the kingdom of the card 
		if(images[rant15].contains(keyword1)==true){
			pathtest15=1;}
		if(images[rant15].contains(keyword2)==true){
			pathtest15=2;}
		if(images[rant15].contains(keyword3)==true){
			pathtest15=3;}
		if(images[rant15].contains(keyword4)==true){
			pathtest15=4;}
		////test for the kingdom of the card 
		if(images[rant16].contains(keyword1)==true){
			pathtest16=1;}
		if(images[rant16].contains(keyword2)==true){
			pathtest16=2;}
		if(images[rant16].contains(keyword3)==true){
			pathtest16=3;}
		if(images[rant16].contains(keyword4)==true){
			pathtest16=4;}
		
				lblAgalmatakia.setVisible(true);
				lblScoreP.setVisible(true);
				btnPlayer.setVisible(true);
				btnPlayer_1.setVisible(true);
				lblScore.setVisible(true);
				lblAgalma.setVisible(true);
				
				
				
				;
				
			}
		});
	}
}
