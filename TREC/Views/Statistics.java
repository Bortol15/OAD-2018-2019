package Views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.HotelController;
import Controllers.MainController;
import Models.HotelActivity;
import Models.TREC;
import ViewModels.CategorySlider;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class Statistics extends JFrame {

	private JPanel contentPane;
	private JTable tbl_statistic;

	
	public Statistics(JTable table) {
		if(TREC.getInstance().getCurrentLoggedInUser() == null)
			return;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStatistiken = new JLabel("Statistics");
		lblStatistiken.setBounds(12, 12, 133, 15);
		lblStatistiken.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblStatistiken);
		
		JComboBox<String> cbx_statistics = new JComboBox<String>();
		cbx_statistics.setBounds(12, 51, 403, 24);
		contentPane.add(cbx_statistics);
		
		
		cbx_statistics.addItem("5 hotels with the best overall evaluations");
		if(TREC.getInstance().getCurrentLoggedInUser().getIs_admin())
		{
			cbx_statistics.addItem("5 hotels with the highest number of customer evaluations");
			cbx_statistics.addItem("5 hotels with the worst overall evaluations");
		}
				
		JButton btnShowStatistics = new JButton("Go");
		btnShowStatistics.setBounds(427, 51, 52, 25);
		contentPane.add(btnShowStatistics);
		btnShowStatistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainController.showStatistics(cbx_statistics.getSelectedItem().toString());
				Statistics.this.dispose();
			}
		});
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 99, 466, 134);
		contentPane.add(scrollPane);
		
		tbl_statistic = table;
		scrollPane.setViewportView(tbl_statistic);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
	}
}
