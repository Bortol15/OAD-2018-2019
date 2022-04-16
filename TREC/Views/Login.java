package Views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Controllers.AuthenticationController;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_EMail;
	private JTextField txt_Password;
	
	public JTextField getEmail() {return txt_EMail;}
	public JTextField getPassword() {return txt_Password;}
	
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 296, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_EMail = new JTextField();
		txt_EMail.setBounds(12, 76, 176, 19);
		contentPane.add(txt_EMail);
		txt_EMail.setColumns(10);
		
		JLabel lblBenutzername = new JLabel("E-Mail:");
		lblBenutzername.setBounds(12, 55, 115, 15);
		contentPane.add(lblBenutzername);
		
		JLabel lblPasswort = new JLabel("Password:");
		lblPasswort.setBounds(12, 107, 115, 15);
		contentPane.add(lblPasswort);
		
		
		txt_Password = new JPasswordField();
		txt_Password.setColumns(10);
		txt_Password.setBounds(12, 133, 176, 19);
		contentPane.add(txt_Password);
		
		JButton btn_login = new JButton("Login");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AuthenticationController.checkLogin(txt_EMail.getText(), txt_Password.getText());
			}
		});
		btn_login.setBounds(12, 164, 114, 25);
		contentPane.add(btn_login);
		
		JLabel lblRegistrieren = new JLabel("Register");
		lblRegistrieren.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {			
				AuthenticationController.showRegistration();
			}
			
		});
		lblRegistrieren.setBounds(209, 19, 65, 19);
		contentPane.add(lblRegistrieren);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 12, 115, 31);
		contentPane.add(lblNewLabel);
	}
	
	public void closeFrame()
	{
		this.dispose();
	}
}
