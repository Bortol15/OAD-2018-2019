import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;

public class Registrierung extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JLabel lblPasswortWiederholen;
	private JTextField textField_2;
	private JLabel lblEmail;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrierung frame = new Registrierung();
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
	public Registrierung() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 466, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setBounds(12, 331, 124, 15);
		contentPane.add(lblPasswort);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 352, 182, 19);
		contentPane.add(textField_1);
		
		lblPasswortWiederholen = new JLabel("Passwort wiederholen:");
		lblPasswortWiederholen.setBounds(223, 331, 202, 15);
		contentPane.add(lblPasswortWiederholen);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(223, 352, 182, 19);
		contentPane.add(textField_2);
		
		lblEmail = new JLabel("E-Mail:");
		lblEmail.setBounds(12, 281, 124, 15);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(12, 302, 182, 19);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Registrierung abschicken");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registrierung.this.dispose();
			}
		});
		btnNewButton.setBounds(12, 399, 216, 25);
		contentPane.add(btnNewButton);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(223, 135, 182, 19);
		contentPane.add(textField_4);
		
		JLabel lblGeburtsdatum = new JLabel("Geburtsdatum:");
		lblGeburtsdatum.setBounds(223, 114, 124, 15);
		contentPane.add(lblGeburtsdatum);
		
		JLabel lblGeschlecht = new JLabel("Geschlecht:");
		lblGeschlecht.setBounds(12, 114, 124, 15);
		contentPane.add(lblGeschlecht);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(12, 79, 182, 19);
		contentPane.add(textField);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setBounds(12, 55, 124, 15);
		contentPane.add(lblVorname);
		
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setBounds(223, 55, 124, 15);
		contentPane.add(lblNachname);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(223, 79, 182, 19);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(12, 195, 182, 19);
		contentPane.add(textField_7);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setBounds(12, 171, 124, 15);
		contentPane.add(lblAdresse);
		
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setBounds(223, 171, 124, 15);
		contentPane.add(lblPlz);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(223, 195, 57, 19);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(12, 250, 182, 19);
		contentPane.add(textField_9);
		
		JLabel lblLand = new JLabel("Land");
		lblLand.setBounds(12, 226, 124, 15);
		contentPane.add(lblLand);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Männlich");
		rdbtnNewRadioButton.setBounds(12, 133, 102, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnW = new JRadioButton("Weiblich");
		rdbtnW.setBounds(118, 133, 89, 23);
		contentPane.add(rdbtnW);
		
		JLabel lblRegistrierung = new JLabel("Registrierung");
		lblRegistrierung.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRegistrierung.setBounds(12, 12, 132, 31);
		contentPane.add(lblRegistrierung);
	}
}
