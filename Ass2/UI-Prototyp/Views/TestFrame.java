package Views;

import java.awt.EventQueue;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TestFrame extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {

		setBounds(100, 100, 667, 449);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel1 = new JPanel();
		panel1.setAlignmentX(Component.LEFT_ALIGNMENT);
		getContentPane().add(panel1);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel1.add(lblNewLabel_2);
		
		JPanel panel2 = new JPanel();
		panel2.setAlignmentX(Component.LEFT_ALIGNMENT);
		getContentPane().add(panel2);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel2.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("oad");
		getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		getContentPane().add(comboBox);
		
	}
}
