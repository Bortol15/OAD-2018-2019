package Views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;

import Controllers.AuthenticationController;
import Models.User;


public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Password;
	private JLabel lblPasswortWiederholen;
	private JTextField txt_repeatPassword;
	private JLabel lblEmail;
	private JTextField txt_EMail;
	private JTextField txt_Birthdate;
	private JTextField txt_Firstname;
	private JTextField txt_Lastname;
	private JTextField txt_Adress;
	private JTextField txt_ZIP;
	private JTextField txt_Country;
	private JRadioButton rbtn_admin;
	private JRadioButton rbtn_customer;
	private JRadioButton rbtn_female;
	private JRadioButton rbtn_male;
	
	public JTextField getEmail() {return txt_EMail;}
	public JTextField getBirthdate() {return txt_Birthdate;}
	public JTextField getFirstname() {return txt_Firstname;}
	public JTextField getLastname() {return txt_Lastname;}
	public JTextField getAdress() {return txt_Adress;}
	public JTextField getZIP() {return txt_ZIP;}
	public JTextField getCountry() {return txt_Country;}
	public JRadioButton getAdmin() {return rbtn_admin;}
	public JRadioButton getCustomer() {return rbtn_customer;}
	public JRadioButton getFemale() {return rbtn_female;}
	public JRadioButton getMale() {return rbtn_male;}

	public Registration() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 445, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPasswort = new JLabel("Password *");
		lblPasswort.setBounds(22, 305, 124, 15);
		contentPane.add(lblPasswort);
		
		txt_Password = new JPasswordField();
		txt_Password.setColumns(10);
		txt_Password.setBounds(22, 325, 182, 19);
		contentPane.add(txt_Password);
		
		lblPasswortWiederholen = new JLabel("Repeat password *");
		lblPasswortWiederholen.setBounds(233, 306, 202, 15);
		contentPane.add(lblPasswortWiederholen);
		
		txt_repeatPassword = new JPasswordField();
		txt_repeatPassword.setColumns(10);
		txt_repeatPassword.setBounds(233, 327, 182, 19);
		contentPane.add(txt_repeatPassword);
		
		lblEmail = new JLabel("E-Mail *");
		lblEmail.setBounds(22, 255, 124, 15);
		contentPane.add(lblEmail);
		
		txt_EMail = new JTextField();
		txt_EMail.setColumns(10);
		txt_EMail.setBounds(22, 275, 182, 19);
		contentPane.add(txt_EMail);
		
		txt_Birthdate = new JTextField();
		txt_Birthdate.setColumns(10);
		txt_Birthdate.setBounds(233, 125, 182, 19);
		contentPane.add(txt_Birthdate);
		
		JLabel lblGeburtsdatum = new JLabel("Birthdate (TT.MM.YYYY)");
		lblGeburtsdatum.setBounds(233, 105, 165, 15);
		contentPane.add(lblGeburtsdatum);
		
		JLabel lblGeschlecht = new JLabel("Gender");
		lblGeschlecht.setBounds(22, 105, 124, 15);
		contentPane.add(lblGeschlecht);
		
		txt_Firstname = new JTextField();
		txt_Firstname.setColumns(10);
		txt_Firstname.setBounds(22, 75, 182, 19);
		contentPane.add(txt_Firstname);
		
		JLabel lblFirstname = new JLabel("Firstname");
		lblFirstname.setBounds(22, 55, 124, 15);
		contentPane.add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setBounds(233, 55, 124, 15);
		contentPane.add(lblLastname);
		
		txt_Lastname = new JTextField();
		txt_Lastname.setColumns(10);
		txt_Lastname.setBounds(233, 75, 182, 19);
		contentPane.add(txt_Lastname);
		
		txt_Adress = new JTextField();
		txt_Adress.setColumns(10);
		txt_Adress.setBounds(22, 175, 182, 19);
		contentPane.add(txt_Adress);
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setBounds(22, 155, 124, 15);
		contentPane.add(lblAdress);
		
		JLabel lblPlz = new JLabel("PLZ");
		lblPlz.setBounds(233, 156, 124, 15);
		contentPane.add(lblPlz);
		
		txt_ZIP = new JTextField();
		txt_ZIP.setColumns(10);
		txt_ZIP.setBounds(233, 175, 57, 19);
		contentPane.add(txt_ZIP);
		
		txt_Country = new JTextField();
		txt_Country.setColumns(10);
		txt_Country.setBounds(22, 225, 182, 19);
		contentPane.add(txt_Country);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(22, 205, 124, 15);
		contentPane.add(lblCountry);
		
		JRadioButton rbtn_male = new JRadioButton("male");
		rbtn_male.setBounds(22, 125, 102, 23);
		contentPane.add(rbtn_male);
		
		JRadioButton rbtn_female = new JRadioButton("femal");
		rbtn_female.setBounds(128, 125, 89, 23);
		contentPane.add(rbtn_female);
		
		JLabel lblRegistrierung = new JLabel("Registration");
		lblRegistrierung.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRegistrierung.setBounds(22, 12, 132, 31);
		contentPane.add(lblRegistrierung);
		
		JRadioButton rbtn_customer = new JRadioButton("customer");
		rbtn_customer.setBounds(22, 375, 102, 23);
		contentPane.add(rbtn_customer);
		
		JRadioButton rbtn_admin = new JRadioButton(" admin");
		rbtn_admin.setBounds(128, 375, 89, 23);
		contentPane.add(rbtn_admin);
		
		JLabel lblRegisterAs = new JLabel("Register as *");
		lblRegisterAs.setBounds(22, 355, 124, 15);
		contentPane.add(lblRegisterAs);
		
		ButtonGroup groupAdminCustomer = new ButtonGroup();
		groupAdminCustomer.add(rbtn_customer);
		groupAdminCustomer.add(rbtn_admin);
		
		ButtonGroup groupGender = new ButtonGroup();
		groupGender.add(rbtn_female);
		groupGender.add(rbtn_male);
		
		JButton submitRegistration = new JButton("Registrierung abschicken");
		submitRegistration.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String gender = "";
				String user_type = "";
				if(rbtn_female.isSelected())
					gender = "female";
				if(rbtn_male.isSelected())
					gender = "male";
				if(rbtn_admin.isSelected())
					user_type = "admin";
				if(rbtn_customer.isSelected())
					user_type = "customer";
					
				if(!AuthenticationController.checkValidity(txt_EMail.getText(), txt_Password.getText(), txt_repeatPassword.getText(), user_type))
				{
					JOptionPane.showMessageDialog(null, "Input not valid!");
					return;
				}
				
				AuthenticationController.register(new User(txt_Firstname.getText(), txt_Lastname.getText(), txt_EMail.getText(),
												  txt_Password.getText(), gender, txt_Birthdate.getText(), txt_Adress.getText(),
												  txt_ZIP.getText(), txt_Country.getText(),rbtn_admin.isSelected() ? true: false));
				Registration.this.dispose();
				
			}
		});
		
		submitRegistration.setBounds(22, 415, 216, 25);
		contentPane.add(submitRegistration);
	}
}
