package View;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.AuthenticationController;
import Controller.UserController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Index extends JFrame {

	private JPanel contentPane;
	public boolean admin = false;
	public boolean logged_in = false;
	JButton btn_interessen = new JButton("Interessen festlegen");
	JButton btn_aktivitaeten = new JButton("Aktivitäten festlegen");
	JButton btnEmpfehlungenErhalten = new JButton("Empfehlungen erhalten");
	public JButton btn_Login = new JButton("Login");
	private JTextField txtSuche;
	UserController userController = new UserController();

	public Index() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 531, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		btn_Login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				AuthenticationController.login();
			}
		});
		btn_Login.setBounds(387, 12, 124, 25);
		contentPane.add(btn_Login);
		
		
		JButton btn_switch_role = new JButton("Zu Admin wechseln");
		btn_switch_role.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(admin == true)
				{
					admin = false;
					btn_switch_role.setText("Zu Admin wechseln");
					btn_interessen.setVisible(true);
					btn_aktivitaeten.setVisible(true);
					btnEmpfehlungenErhalten.setVisible(true);
					
				}
				else
				{
					admin = true;
					btn_switch_role.setText("Zu Kunde wechseln");
					btn_interessen.setVisible(false);
					btn_aktivitaeten.setVisible(false);
					btnEmpfehlungenErhalten.setVisible(false);
				}				
			}
		});
		btn_switch_role.setBounds(309, 232, 202, 25);
		contentPane.add(btn_switch_role);
		
		JButton btnNewButton = new JButton("Suche");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Search().setVisible(true);
			}
		});
		btnNewButton.setBounds(387, 56, 124, 25);
		contentPane.add(btnNewButton);
		
		txtSuche = new JTextField();
		txtSuche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSuche.setText("");
			}
		});
		txtSuche.setText("Suche ...");
		txtSuche.setBounds(387, 87, 124, 19);
		contentPane.add(txtSuche);
		txtSuche.setColumns(10);


		btnEmpfehlungenErhalten.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(admin == true)
					new RecommendationsCustomer().setVisible(true);
				else
					new RecommendationsCustomer().setVisible(true);
			}
		});
		btnEmpfehlungenErhalten.setBounds(12, 232, 196, 25);
		contentPane.add(btnEmpfehlungenErhalten);
		
		JButton btnNewButton_1 = new JButton("Statistik anzeigen");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Statistics().setVisible(true);
			}
		});

		btnNewButton_1.setBounds(12, 196, 158, 25);
		contentPane.add(btnNewButton_1);
		

		btn_interessen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userController.ShowInterests();
			}
		});
		btn_interessen.setBounds(12, 56, 180, 25);
		contentPane.add(btn_interessen);
		

		btn_aktivitaeten.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userController.ShowActivities();
			}
		});
		btn_aktivitaeten.setBounds(12, 96, 180, 25);
		contentPane.add(btn_aktivitaeten);
		
		JLabel lblNewLabel = new JLabel("T-REC");
		lblNewLabel.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 22));
		lblNewLabel.setBounds(236, 12, 101, 38);
		contentPane.add(lblNewLabel);
	}
}
