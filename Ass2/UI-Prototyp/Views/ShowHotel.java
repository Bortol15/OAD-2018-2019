package Views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Models.Category;
import Models.Hotel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowHotel extends JFrame {

	private JPanel contentPane;

	public ShowHotel(Hotel hotel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(hotel.Name);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 12, 234, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblLand = new JLabel("Destination:");
		lblLand.setBounds(12, 39, 86, 15);
		contentPane.add(lblLand);
		
		JLabel lblNewLabel_1 = new JLabel(hotel.Destination);
		lblNewLabel_1.setBounds(110, 39, 150, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblLand_1 = new JLabel("Country:");
		lblLand_1.setBounds(12, 66, 86, 15);
		contentPane.add(lblLand_1);
		
		JLabel asdf = new JLabel("bottom:");
		asdf.setBounds(12, 366, 86, 15);
		contentPane.add(asdf);
		
		JLabel lblKroatien = new JLabel(hotel.Country);
		lblKroatien.setBounds(110, 66, 150, 15);
		contentPane.add(lblKroatien);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBounds(12, 147, 158, 165);
		contentPane.add(panel);
		JPanel container = new JPanel();
		JScrollPane scrPane = new JScrollPane(container);
		getContentPane().add(scrPane);
//		
		
		for(int i = 0; i < hotel.Activities.size(); i++)
		{
			Category temp_activity = hotel.Activities.get(i);
			JLabel temp_label = new JLabel(temp_activity.Name + ": " + temp_activity.Value);
			panel.add(temp_label);
		}
		
		JLabel lblAktivitten = new JLabel("Activities:");
		lblAktivitten.setFont(new Font("Dialog", Font.ITALIC, 14));
		lblAktivitten.setBounds(12, 129, 101, 15);
		contentPane.add(lblAktivitten);
		
		JButton btnBewertungAbgeben = new JButton("Rate Hotel");
		btnBewertungAbgeben.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RateHotel().setVisible(true);
				ShowHotel.this.dispose();
			}
		});
		btnBewertungAbgeben.setBounds(231, 287, 197, 25);
		contentPane.add(btnBewertungAbgeben);
	}
	public ShowHotel() {}
}
