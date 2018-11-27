package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Hotel;
import Model.Category;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowHotel extends JFrame {

	private JPanel contentPane;

	public ShowHotel(Hotel hotel1) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Apartment Sole di Pola");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 12, 234, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblLand = new JLabel("Reiseziel:");
		lblLand.setBounds(12, 39, 66, 15);
		contentPane.add(lblLand);
		
		JLabel lblNewLabel_1 = new JLabel("Pula");
		lblNewLabel_1.setBounds(90, 39, 66, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblKroatien = new JLabel("Kroatien");
		lblKroatien.setBounds(90, 66, 66, 15);
		contentPane.add(lblKroatien);
		
		JLabel lblLand_1 = new JLabel("Land:");
		lblLand_1.setBounds(12, 66, 66, 15);
		contentPane.add(lblLand_1);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBounds(12, 147, 158, 165);
		contentPane.add(panel);
		
		
		for(int i = 0; i < hotel1.Activities.size(); i++)
		{
			Category temp_activity = hotel1.Activities.get(i);
			JLabel temp_label = new JLabel(temp_activity.name + ": " + temp_activity.value);
			panel.add(temp_label);
		}
		
		JLabel lblAktivitten = new JLabel("Aktivitäten:");
		lblAktivitten.setFont(new Font("Dialog", Font.ITALIC, 14));
		lblAktivitten.setBounds(12, 129, 101, 15);
		contentPane.add(lblAktivitten);
		
		JButton btnBewertungAbgeben = new JButton("Bewertung abgeben");
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
}
