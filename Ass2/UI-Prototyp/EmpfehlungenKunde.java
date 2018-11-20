import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmpfehlungenKunde extends JFrame {

	private JPanel contentPane;
	List<String> recommendet_destinations = new ArrayList();
	List<String> recommendet_hotels_pula = new ArrayList();
	List<String> recommendet_hotels_mallorca = new ArrayList();
	Map<String,JLabel> destination_labels_map = new HashMap();
	Map<String,List<String>> destination_map = new HashMap();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpfehlungenKunde frame = new EmpfehlungenKunde();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void fillList()
	{
		recommendet_destinations.add("Pula");
		recommendet_destinations.add("Palma de Mallorca");
		
		recommendet_hotels_pula.add("Pula Art host");
		recommendet_hotels_pula.add("Hotel Galija");
		recommendet_hotels_pula.add("Scaletta");
		
		recommendet_hotels_mallorca.add("Melia Palma Bay");
		recommendet_hotels_mallorca.add("Hotel Costa Azul");
		recommendet_hotels_mallorca.add("Art Hotel Palma");
		
		destination_map.put("Pula", recommendet_hotels_pula);
		destination_map.put("Palma de Mallorca", recommendet_hotels_mallorca);
	}
	/**
	 * Create the frame.
	 */
	public EmpfehlungenKunde() {
		fillList();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_customer_recommendations = new JLabel("Deine empfohlenen Reiseziele");
		lbl_customer_recommendations.setFont(new Font("Dialog", Font.BOLD, 16));
		lbl_customer_recommendations.setBounds(12, 12, 296, 19);
		contentPane.add(lbl_customer_recommendations);
		
		for(int i = 0; i < recommendet_destinations.size(); i++)
		{
			String destination_name = recommendet_destinations.get(i);
			JLabel lblNewLabel = new JLabel(String.valueOf(i+1) +". " + destination_name);
			lblNewLabel.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e) {
					Iterator it = destination_labels_map.entrySet().iterator();
					while(it.hasNext())
					{
						Map.Entry pair = (Map.Entry) it.next();
						JLabel temp = (JLabel)pair.getValue();
						temp.setVisible(false);
					}
					lbl_customer_recommendations.setText("Deine empfohlenden Hotels");
					List<String> hotels = destination_map.get(destination_name);
					for(int i = 0; i < hotels.size(); i++)
					{
						JLabel lbl_hotels = new JLabel(String.valueOf(i+1) +". " + hotels.get(i));
						lbl_hotels.addMouseListener(new MouseAdapter()
						{
							public void mouseClicked(MouseEvent e) {
								new HotelAnzeigen().setVisible(true);
							}
						});
						lbl_hotels.setBounds(12, 57+i*20, 180, 15);
						contentPane.add(lbl_hotels);					
					}
				}
			});
			lblNewLabel.setBounds(12, 57+i*20, 180, 15);
			contentPane.add(lblNewLabel);
			destination_labels_map.put(recommendet_destinations.get(i), lblNewLabel);
		}
	}
}
