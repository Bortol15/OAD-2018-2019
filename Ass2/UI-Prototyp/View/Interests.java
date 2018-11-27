package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.event.ChangeListener;

import Model.Customer;
import Model.Activity;

import javax.swing.event.ChangeEvent;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interests extends JFrame {

	private JPanel contentPane;
	private JButton btn_submit;
	Map<String,JSlider> Sliders = new HashMap<String,JSlider>();
	Map<String,JLabel>Labels = new HashMap<String,JLabel>();
	private JSlider slider;
	private JLabel lblNewLabel_1;
	private JLabel label;

	public Interests(Customer customer1) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, -13, 320, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Speichern");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Interests.this.dispose();
			}
		});
		btnNewButton.setBounds(12, 191, 114, 25);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel = new JLabel("Interessen festlegen");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 12, 257, 22);
		contentPane.add(lblNewLabel);
		listThemes(customer1.Interests);
	}

	public void listThemes(List<Activity> list)
	{
		for(int i = 0; i < list.size(); i++)
		{
			String activity_name = list.get(i).name;
			
			lblNewLabel_1 = new JLabel(list.get(i).name);
			lblNewLabel_1.setBounds(12, 53+i*20, 150, 15);
			contentPane.add(lblNewLabel_1);
					
			slider = new JSlider();
			slider.setName("slider_" + activity_name);
			slider.setMaximum(10);
			slider.setMinimum(0);
			slider.setBounds(160, 53+i*20, 114, 16);
			slider.setValue(list.get(i).value);
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					JLabel temp_label = Labels.get(activity_name);
					JSlider temp_slider = Sliders.get(activity_name);
					temp_label.setText(String.valueOf(temp_slider.getValue()));
				}
			});
			contentPane.add(slider);
			Sliders.put(activity_name, slider);
			
			label = new JLabel(String.valueOf(slider.getValue()));
			label.setBounds(300, 53+i*20, 80, 15);
			contentPane.add(label);
			Labels.put(list.get(i).name, label);
		}	
	}
}
