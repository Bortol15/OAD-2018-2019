package Views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.AuthenticationController;
import Controllers.HotelController;
import Controllers.RecommendationController;
import Controllers.UserController;
import Models.Destination;
import Models.Hotel;
import Models.TREC;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class Index extends JFrame {

	private JPanel contentPane;
	public JLabel lbl_user_logged_in = new JLabel("");
	private JButton btn_interests = new JButton("Set Interests");
	private JButton btn_aktivities = new JButton("Set Activities");
	private JButton btn_Recommendations = new JButton("Get Recommendations");
	private JButton btn_Login = new JButton("Login");
	private JTextField txt_Search;
	UserController userController = new UserController();
	
	public JButton getLogin() {return btn_Login;};

	public Index() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 531, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl_user_logged_in.setBounds(12, 17, 180, 15);
		contentPane.add(lbl_user_logged_in);
				
		btn_Login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				AuthenticationController.login();
			}
		});
		btn_Login.setBounds(387, 12, 124, 25);
		contentPane.add(btn_Login);
		
		JButton btn_Search = new JButton("Search");
		btn_Search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotelController.searchHotels(txt_Search.getText());
			}
		});
		btn_Search.setBounds(387, 56, 124, 25);
		contentPane.add(btn_Search);
		
		txt_Search = new JTextField();
		txt_Search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		txt_Search.setBounds(387, 87, 124, 19);
		contentPane.add(txt_Search);
		txt_Search.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("T-REC");
		lblNewLabel.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 22));
		lblNewLabel.setBounds(236, 12, 101, 38);
		contentPane.add(lblNewLabel);
		
		if(TREC.getInstance().getCurrentLoggedInUser() == null)
			return;

		btn_Recommendations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(TREC.getInstance().getCurrentLoggedInUser().getIs_admin())
					RecommendationController.showAdminRecommendation();
				else
					RecommendationController.showCustomerRecommendation();
			}
		});
		btn_Recommendations.setBounds(12, 232, 196, 25);
		contentPane.add(btn_Recommendations);
		
		JButton btn_Statistics = new JButton("Show Statistics");
		btn_Statistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Statistics().setVisible(true);
			}
		});

		btn_Statistics.setBounds(12, 196, 158, 25);
		contentPane.add(btn_Statistics);
		

		if(TREC.getInstance().getCurrentLoggedInUser().getIs_admin())
		{
			JComboBox<Hotel> cbx_MaintainHotel = new JComboBox<Hotel>();
			cbx_MaintainHotel.setBounds(12, 66, 151, 24);
			contentPane.add(cbx_MaintainHotel);
			for(Hotel hotel: TREC.getInstance().getCurrentLoggedInUser().getHotels())
				cbx_MaintainHotel.addItem(hotel);
			
			JButton btn_MaintainHotel = new JButton("Maintain Hotel");
			btn_MaintainHotel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					HotelController.maintainHotel((Hotel)cbx_MaintainHotel.getSelectedItem());
				}
			});
			btn_MaintainHotel.setBounds(12, 102, 151, 25);
			contentPane.add(btn_MaintainHotel);
			
		}
		else
		{
			btn_interests.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					userController.ShowInterests();
				}
			});
			btn_interests.setBounds(12, 66, 180, 25);
			contentPane.add(btn_interests);
			
	
			btn_aktivities.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					userController.ShowActivities();
				}
			});
			btn_aktivities.setBounds(12, 106, 180, 25);
			contentPane.add(btn_aktivities);
		}
	}
}
