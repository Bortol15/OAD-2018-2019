package Views;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Statistics extends JFrame {

	private JPanel contentPane;
	private JTable tbl_statistic;

	
	public Statistics() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStatistiken = new JLabel("Statistiken");
		lblStatistiken.setBounds(12, 12, 133, 15);
		lblStatistiken.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblStatistiken);
		
		JComboBox cbx_statistics = new JComboBox();
		cbx_statistics.setBounds(12, 51, 403, 24);
		contentPane.add(cbx_statistics);
		
		cbx_statistics.addItem("3 Kunden mit der höchsten Zahl an Evaluierungen");
		cbx_statistics.addItem("5 Hotels mit den besten Evaluierungen");
		cbx_statistics.addItem("5 Hotels mit der höchsten Zahl an Kundenevaluierungen");
		
		
		String[] columnNames = {"Vorname",
                "Nachname",
                "Anzahl Evaluierungen"
                };
		
		Object[][] data = {
				{"Max","Mustermann", 5},
				{"Susi","Sonnenschein", 4},
				{"Christoph","Proß", 3},
			};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 112, 403, 134);
		contentPane.add(scrollPane);
		
		tbl_statistic = new JTable(data,columnNames);
		scrollPane.setViewportView(tbl_statistic);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());

	}

}
