import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Anmeldung extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anmeldung frame = new Anmeldung();
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
	public Anmeldung() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 309, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 76, 176, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBenutzername = new JLabel("E-Mail:");
		lblBenutzername.setBounds(12, 55, 115, 15);
		contentPane.add(lblBenutzername);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setBounds(12, 107, 115, 15);
		contentPane.add(lblPasswort);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 133, 176, 19);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Anmelden");
		btnNewButton.setBounds(12, 164, 114, 25);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("Passwort vergessen?");
		label.setBounds(12, 204, 159, 19);
		contentPane.add(label);
		
		JLabel lblRegistrieren = new JLabel("Registrieren");
		lblRegistrieren.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {			
				new Registrierung().setVisible(true);
				closeFrame();
			}
			
		});
		lblRegistrieren.setBounds(12, 235, 159, 19);
		contentPane.add(lblRegistrieren);
		
		JLabel lblNewLabel = new JLabel("Anmeldung");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 12, 115, 31);
		contentPane.add(lblNewLabel);
	}
	
	public void closeFrame()
	{
		this.dispose();
	}
}
