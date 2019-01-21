package Views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class RecommendationsAdmin extends JFrame {

	private JPanel contentPane;

	public RecommendationsAdmin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeineEmpfohlenenKunden = new JLabel("Deine empfohlenen Kunden");
		lblDeineEmpfohlenenKunden.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDeineEmpfohlenenKunden.setBounds(12, 12, 256, 15);
		contentPane.add(lblDeineEmpfohlenenKunden);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 52, 66, 15);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(96, 47, 108, 24);
		contentPane.add(comboBox);
	}
}
