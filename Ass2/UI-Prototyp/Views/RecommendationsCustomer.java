package Views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.HotelController;
import Models.Destination;
import Models.Hotel;
import ViewModels.RecommendationViewModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RecommendationsCustomer extends JFrame {

	private JPanel contentPane;
	Map<String,JLabel> destination_labels_map = new HashMap<String, JLabel>();
	Map<String,List<String>> destination_map = new HashMap<String, List<String>>();

	public RecommendationsCustomer(RecommendationViewModel model) {
		
		if(model == null)
			return;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_destination_rec = new JLabel("Your recommendet Destinations!");
		lbl_destination_rec.setFont(new Font("Dialog", Font.BOLD, 16));
		lbl_destination_rec.setBounds(12, 12, 396, 19);
		contentPane.add(lbl_destination_rec);
		
		
		JLabel lbl_back = new JLabel("back");
		lbl_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				RecommendationController.showCustomerRecommendation();
				new RecommendationsCustomer(model).setVisible(true);
				RecommendationsCustomer.this.dispose();
			}
		});
		lbl_back.setBounds(342, 15, 66, 15);
		contentPane.add(lbl_back);
		lbl_back.setVisible(false);
		
		
		for(int i = 0; i < model.destinations.size() && i < 3; i++)
		{
			Destination dest = model.destinations.get(i);
			String destination_name = dest.getName();
			JLabel lblNewLabel = new JLabel(String.valueOf(i+1) +". " + destination_name);
			lblNewLabel.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e) {
					lbl_back.setVisible(true);
					for (Map.Entry<String, JLabel> entry : destination_labels_map.entrySet())
						entry.getValue().setVisible(false);
					
					lbl_destination_rec.setText("Hotels in "+ dest.getName());
					for(int j = 0; j < dest.getHotels().size(); j++)
					{
						JLabel lbl_hotels = new JLabel(String.valueOf(j+1) +". " + dest.getHotels().get(j));
						int id = dest.getHotels().get(j).getId();
						lbl_hotels.addMouseListener(new MouseAdapter()
						{
							public void mouseClicked(MouseEvent e) {
								HotelController.showHotel(id);
							}
						});
						lbl_hotels.setBounds(12, 47+j*20, 180, 15);
						contentPane.add(lbl_hotels);					
					}				
				}
			});
			lblNewLabel.setBounds(12, 47+i*20, 180, 15);
			contentPane.add(lblNewLabel);
			destination_labels_map.put(model.destinations.get(i).getName(), lblNewLabel);
		}
		
		JLabel lbl_hotels_rec = new JLabel("Your recommendet Hotels!");
		lbl_hotels_rec.setFont(new Font("Dialog", Font.BOLD, 16));
		lbl_hotels_rec.setBounds(12, 125, 296, 19);
		contentPane.add(lbl_hotels_rec);

		for(int i = 0; i < model.hotels.size() && i < 3; i++)
		{
			Hotel hotel = model.hotels.get(i);
			String hotel_name = hotel.getName();
			JLabel lblNewLabel = new JLabel(String.valueOf(i+1) +". " + hotel_name);
			lblNewLabel.addMouseListener(new MouseAdapter()
			{
				int id = hotel.getId();
				public void mouseClicked(MouseEvent e)
				{
					HotelController.showHotel(id);
				}

			});
			
			lblNewLabel.setBounds(12, 155+i*20, 180, 15);
			contentPane.add(lblNewLabel);
		}
	}
}
