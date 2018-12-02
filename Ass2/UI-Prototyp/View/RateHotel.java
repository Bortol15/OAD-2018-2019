package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import Model.Category;

import javax.swing.event.ChangeEvent;
import java.awt.Font;



public class RateHotel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btn_submit;
	List<Category> Activities = new ArrayList();
	Map<String,JSlider> Sliders = new HashMap<String,JSlider>();
	Map<String,JLabel>Labels = new HashMap<String,JLabel>();
	private JSlider slider;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel lblKommentar;
	private JLabel lblNewLabel;
	
	public RateHotel() {
		fillList();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 355, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(268, 206, 37, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNchte = new JLabel("Dauer des Aufenthalts (Nächte):");
		lblNchte.setBounds(12, 208, 233, 15);
		contentPane.add(lblNchte);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(12, 264, 293, 109);
		contentPane.add(editorPane);
		
		btn_submit = new JButton("Abschicken");
		btn_submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String text = "";
				Iterator it = Sliders.entrySet().iterator();
				while(it.hasNext())
				{
					Map.Entry pair = (Map.Entry) it.next();
					JSlider temp = (JSlider)pair.getValue();
					text += pair.getKey() + ": " + String.valueOf(temp.getValue() +"\n");
				}
				JOptionPane.showMessageDialog(null, text);
				RateHotel.this.dispose();
			}
		});
		btn_submit.setBounds(12, 385, 114, 25);
		contentPane.add(btn_submit);
		
		lblKommentar = new JLabel("Kommentar:");
		lblKommentar.setBounds(12, 235, 114, 15);
		contentPane.add(lblKommentar);
		
		lblNewLabel = new JLabel("Apartment Sole di Pola");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 12, 251, 15);
		contentPane.add(lblNewLabel);
		listActivities();
		

	}
	public void fillList()
	{
		Activities.add(new Category("Schwimmen"));
		Activities.add(new Category("Tennis"));
		Activities.add(new Category("Geschichte"));
		Activities.add(new Category("Volleyball"));
		
	}
	public void listActivities()
	{
		for(int i = 0; i < Activities.size(); i++)
		{
			String activity_name = Activities.get(i).Name;
			
			lblNewLabel_1 = new JLabel(Activities.get(i).Name);
			lblNewLabel_1.setBounds(12, 53+i*20, 150, 15);
			contentPane.add(lblNewLabel_1);
					
			slider = new JSlider();
			slider.setName("slider_" + activity_name);
			slider.setMaximum(10);
			slider.setMinimum(0);
			slider.setBounds(160, 53+i*20, 114, 16);
			slider.setValue(Activities.get(i).Value);
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
			Labels.put(Activities.get(i).Name, label);
		}	
	}
}
