package Views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.AuthenticationController;
import Controllers.HotelController;
import Controllers.MainController;
import Controllers.RecommendationController;
import Controllers.UserController;
import Models.Destination;
import Models.Hotel;
import Models.TREC;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index extends JFrame {

	private JPanel contentPane;
	public JLabel lbl_user_logged_in = new JLabel("");
	private JButton btn_interests = new JButton("Set Interests");
	private JButton btn_aktivities = new JButton("Set Activities");
	private JButton btn_Recommendations = new JButton("Get Recommendations");
	private JButton btn_Login = new JButton("Login");
	public JComboBox<Hotel> cbx_MaintainHotel = new JComboBox<Hotel>();
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
		Font font = lbl_user_logged_in.getFont();
		Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lbl_user_logged_in.setFont(font.deriveFont(attributes));


				
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
				new Statistics(null).setVisible(true);
			}
		});

		btn_Statistics.setBounds(220, 232, 158, 25);
		contentPane.add(btn_Statistics);

		if(TREC.getInstance().getCurrentLoggedInUser().getIs_admin())
		{
			JLabel lblNewLabel_1 = new JLabel("Hotels:");
			lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(22, 71, 129, 15);
			contentPane.add(lblNewLabel_1);
			
			cbx_MaintainHotel.setBounds(22, 102, 158, 24);
			contentPane.add(cbx_MaintainHotel);
			for(Hotel hotel: TREC.getInstance().getCurrentLoggedInUser().getHotels())
				cbx_MaintainHotel.addItem(hotel);
			
			JButton btn_MaintainHotel =  new JButton("Edit");
			btn_MaintainHotel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					HotelController.maintainHotel((Hotel)cbx_MaintainHotel.getSelectedItem());
				}
			});
			btn_MaintainHotel.setBounds(22, 138, 80, 25);
			contentPane.add(btn_MaintainHotel);
			
			JButton button = new JButton("-");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					int input = JOptionPane.showConfirmDialog(null, "Do you like bacon?");
//					int dialogButton = JOptionPane.YES_NO_OPTION;
					if(JOptionPane.showConfirmDialog(null, "Are you sure, you want delete this item?") == 0)
					{
						HotelController.deleteHotel((Hotel)cbx_MaintainHotel.getSelectedItem());
						cbx_MaintainHotel.removeItem(cbx_MaintainHotel.getSelectedItem());
					}
				}
			});
			button.setBounds(185, 102, 44, 25);
			contentPane.add(button);
			
			
			JButton btn_NewHotel = new JButton("+");
			btn_NewHotel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					HotelController.showNewHotel();
				}
			});
			btn_NewHotel.setBounds(234, 102, 44, 25);
			contentPane.add(btn_NewHotel);
			
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
