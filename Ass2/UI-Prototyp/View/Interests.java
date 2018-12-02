package View;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import Controller.UserController;

import java.awt.Font;
import java.util.Iterator;
import java.util.Map;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import ViewModels.*;

public class Interests extends JFrame {

	private JPanel contentPane;
	UserController userController = new UserController();

	public Interests(CategoriesViewModel model) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, -13, 320, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSave = new JButton("Speichern");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userController.saveInterests(model);
			}
		});
		btnSave.setBounds(12, 191, 114, 25);
		contentPane.add(btnSave);
		
		
		JLabel lblNewLabel = new JLabel("Set Interests");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 12, 257, 22);
		contentPane.add(lblNewLabel);
		
		Iterator it = model.NameLabels.entrySet().iterator();
		
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry) it.next();
			String name = pair.getKey().toString();
			contentPane.add(model.NameLabels.get(name));
			contentPane.add(model.Sliders.get(name));
			contentPane.add(model.ValueLabels.get(name));
		}
	}
	public Interests() {}
}
