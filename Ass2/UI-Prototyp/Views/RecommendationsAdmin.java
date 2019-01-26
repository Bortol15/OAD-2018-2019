package Views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;

public class RecommendationsAdmin extends JFrame {

	private JPanel contentPane;

	public RecommendationsAdmin(List<User> users) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_destination_rec = new JLabel("Your recommendet Customers!");
		lbl_destination_rec.setFont(new Font("Dialog", Font.BOLD, 16));
		lbl_destination_rec.setBounds(12, 12, 396, 19);
		contentPane.add(lbl_destination_rec);
		
		for(int i = 0; i < users.size(); i++)
		{
			String username = users.get(i).getEMail() + " --> " + users.get(i).getHotels().get(0).getName();
			JLabel lblNewLabel = new JLabel(username);
			lblNewLabel.setBounds(12, 47+i*20, 366, 15);
			contentPane.add(lblNewLabel);
		}		
	}
}
