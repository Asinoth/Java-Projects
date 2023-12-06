package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToixografiesNewWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void toixografiesnew() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToixografiesNewWindow frame = new ToixografiesNewWindow();
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
	public ToixografiesNewWindow() {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//label for the drawings 
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"Omorfes Minoitisses poy koybentiazoyn. Exoyn oraia foremata, symfona me ti moda tis epoxis, omorfa xtenismena mallia kai polytima kosmimata.");
			}
		});
		lblNewLabel.setBounds(5, 5, 216, 127);
		lblNewLabel.setIcon(new ImageIcon(ToixografiesNewWindow.class.getResource("/findings/fresco1_20.jpg")));
		contentPane.add(lblNewLabel);
		//label for the drawings 
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"I toixografia ayti proerxetai apo to megaro tis basilissas. Delfinia kolympoyn anamesa se psaria, mesa sta kymata.");
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(ToixografiesNewWindow.class.getResource("/findings/fresco3_15.jpg")));
		lblNewLabel_1.setBounds(15, 143, 216, 88);
		contentPane.add(lblNewLabel_1);
		//label for the drawings 
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"Ta tayrokathapsia itan ena agonisma poy synithizotan poly sta minoika xronia. Perilambane to piasimo toy tayroy apo ta kerata, to epikindyno alma sti raxi toy zooy kai telos to pidima sto edafos piso toy.");
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(ToixografiesNewWindow.class.getResource("/findings/fresco2_20.jpg")));
		lblNewLabel_2.setBounds(227, 5, 197, 147);
		contentPane.add(lblNewLabel_2);
	}

}
