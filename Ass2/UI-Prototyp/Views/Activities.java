package Views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.UserController;
import Models.Category;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import ViewModels.*;

public class Activities extends JFrame {

	private JPanel contentPane;
	UserController userController = new UserController();

	public Activities(List<CategorySlider> catSliders) {

		int offset = (catSliders.size() - 5) * 20;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, -13, 320, 258+offset);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userController.saveActivities(catSliders);
				Activities.this.dispose();
			}
		});
		btnSave.setBounds(12, 191+offset, 114, 25);
		contentPane.add(btnSave);
		
		
		JLabel lblNewLabel = new JLabel("Set Activities");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 12, 257, 22);
		contentPane.add(lblNewLabel);
		
		for(CategorySlider catSlider : catSliders)
		{
			contentPane.add(catSlider.Name);
			contentPane.add(catSlider.Slider);
			contentPane.add(catSlider.Value);
		}
	}
	public Activities() {}
}
