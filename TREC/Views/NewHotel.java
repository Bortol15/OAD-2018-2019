package Views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Controllers.HotelController;
import Models.Category;
import Models.Destination;
import Models.Evaluation;
import Models.User;
import ViewModels.MaintainHotelModel;
import ViewModels.NewHotelModel;

public class NewHotel extends JFrame{

	private JPanel contentPane;
	private JComboBox<String> cbx_activities = new JComboBox<String>();
	private JComboBox<Destination> cbx_Destinations = new JComboBox<Destination>();
	private JTextField txt_Country;

	public NewHotel(NewHotelModel model) {
		

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setPreferredSize(new Dimension(500, 230));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblName.setBounds(12, 12, 100, 25);
		contentPane.add(lblName);
		
		JTextField txt_name = new JTextField();
		txt_name.setFont(new Font("Dialog", Font.BOLD, 18));
		txt_name.setBounds(120, 12, 250, 25);
		contentPane.add(txt_name);

		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDestination.setBounds(12, 52, 130, 15);
		contentPane.add(lblDestination);
		

		cbx_Destinations.setBounds(120, 52, 150, 20);
		contentPane.add(cbx_Destinations);
		for(Destination dest : model.destinations.values())
			cbx_Destinations.addItem(dest);
		
//		txt_Country.setText(cbx_Destinations.getSelectedItem().toString());
		
		
		cbx_Destinations.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Destination dest = (Destination) arg0.getItem();
				txt_Country.setText(dest.getCountry());
			}
		});
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCountry.setBounds(12, 82, 86, 15);
		contentPane.add(lblCountry);
		
		txt_Country = new JTextField();
		txt_Country.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_Country.setBounds(120, 82, 150, 20);
		txt_Country.setEditable(false);
		contentPane.add(txt_Country);
		
		JLabel lblAdddress = new JLabel("Address:");
		lblAdddress.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAdddress.setBounds(12, 112, 86, 15);
		contentPane.add(lblAdddress);
		
		JTextField txt_Address = new JTextField();
		txt_Address.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_Address.setBounds(120, 112, 342, 20);
		contentPane.add(txt_Address);
		
		JLabel lblStars = new JLabel("Stars:");
		lblStars.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStars.setBounds(12, 142, 86, 15);
		contentPane.add(lblStars);
		
		JTextField txt_Stars = new JTextField("0");
		txt_Stars.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_Stars.setBounds(120, 142, 150, 20);
		contentPane.add(txt_Stars);
		
		JButton btnSubmit = new JButton("Save Changes");
		btnSubmit.setBounds(12, 182, 135, 25);
		contentPane.add(btnSubmit);
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.hotel.setDestination((Destination)cbx_Destinations.getSelectedItem());
				model.hotel.setName(txt_name.getText());
				model.hotel.setStars(Integer.parseInt(txt_Stars.getText()));
				model.hotel.setAddress(txt_Address.getText());
				HotelController.saveNewHotel(model.hotel);
				NewHotel.this.dispose();
			}
		});
        pack();
        setVisible(true);
	}
}
